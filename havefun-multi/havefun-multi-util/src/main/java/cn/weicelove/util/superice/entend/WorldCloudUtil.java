package cn.weicelove.util.superice.entend;

import cn.weicelove.util.random.RandomUtil;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.Word;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.image.AngleGenerator;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.placement.RTreeWordPlacer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/11/13 11:41
 */
public class WorldCloudUtil extends WordCloud {

    private static final Logger logger = LoggerFactory.getLogger(WorldCloudUtil.class);

    public WorldCloudUtil(Dimension dimension, CollisionMode collisionMode) {
        super(dimension, collisionMode);
    }

    public static void main(String[] args) {
        WorldCloudUtil worldCloudUtil = new WorldCloudUtil(new Dimension(1000, 1000), CollisionMode.PIXEL_PERFECT);
        // worldCloudUtil.setPadding(2); 间距
        worldCloudUtil.setWordPlacer(new RTreeWordPlacer());
        worldCloudUtil.setAngleGenerator(new AngleGenerator(0D, 90D, 5));
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            WordFrequency wordFrequency = new WordFrequency(RandomUtil.generateEnglishLetter(6),
                    new Random().nextInt(1000));
            wordFrequencies.add(wordFrequency);
        }
        worldCloudUtil.build(wordFrequencies);
        worldCloudUtil.writeToFile("c:/anruoxin/pic/test1.png");


    }

    @Override
    protected List<Word> buildWords(final List<WordFrequency> wordFrequencies, final ColorPalette colorPalette) {
        logger.info("调用本地的方法");
        final int maxFrequency = maxFrequency(wordFrequencies);

        final List<Word> words = new ArrayList<>();
        for (final WordFrequency wordFrequency : wordFrequencies) {
            // the text shouldn't be empty, however, in case of bad normalizers/tokenizers, this may happen
            if (!wordFrequency.getWord().isEmpty()) {
                words.add(buildWord(wordFrequency, maxFrequency, colorPalette));
            }
        }
        return words;
    }

    private static int maxFrequency(final List<WordFrequency> wordFrequencies) {
        if (wordFrequencies.isEmpty()) { return 1; }

        return wordFrequencies.get(0).getFrequency();
    }

    private Word buildWord(final WordFrequency wordFrequency, final int maxFrequency, final ColorPalette colorPalette) {
        final Graphics graphics = this.bufferedImage.getGraphics();
        final int frequency = wordFrequency.getFrequency();
        final float fontHeight = this.fontScalar.scale(frequency, 0, maxFrequency);
        final Font font = kumoFont.getFont().deriveFont(fontHeight);
        final FontMetrics fontMetrics = graphics.getFontMetrics(font);
        final Word word = new Word(wordFrequency.getWord(), colorPalette.next(), fontMetrics, this.collisionChecker);
        final double theta = angleGenerator.randomNext();
        if (theta != 0.0) {
            word.setBufferedImage(generateBufferedImage(word.getBufferedImage(), theta));
        }
        if (padding > 0) {
            padder.pad(word, padding);
        }
        return word;
    }

    private BufferedImage generateBufferedImage(BufferedImage bufferedImage, double theta){
        if (theta == 0.0) { return bufferedImage; }

        final double sin = Math.abs(Math.sin(theta));
        final double cos = Math.abs(Math.cos(theta));
        final int weight = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();
        final int newWeight = (int) Math.floor(weight * cos + height * sin);
        final int newHeight = (int) Math.floor(height * cos + weight * sin);

        final BufferedImage result = new BufferedImage(newWeight, newHeight, bufferedImage.getType());
        final Graphics2D graphics = result.createGraphics();
        graphics.translate((newWeight - weight) / 2.0, (newHeight - height) / 2.0);
        graphics.rotate(theta, weight / 2.0, height / 2.0);
        graphics.drawRenderedImage(bufferedImage, null);
        graphics.dispose();

        String name = "c:/anruoxin/pic/other/" + RandomUtil.generateEnglishLetter(15)+ ".png";
        try {
            logger.info("file name {}", name);
            ImageIO.write(bufferedImage,"png" ,new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
