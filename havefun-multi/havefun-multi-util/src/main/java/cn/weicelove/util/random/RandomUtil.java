package cn.weicelove.util.random;

import java.util.Random;

/**
 * @author QIU PANWEI Create in 2019/11/13 13:38
 */
public class RandomUtil {

    private static final char [] NUMBER_LETTER = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final char [] ENGLISH_LETTER = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
    'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String generateEnglishLetter(int  digit) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            stringBuilder.append(ENGLISH_LETTER[random.nextInt(26)]);
        }
        return stringBuilder.toString();
    }

    public static String generateNumberLetter(int  digit) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            stringBuilder.append(NUMBER_LETTER[random.nextInt(10)]);
        }
        return stringBuilder.toString();
    }

}
