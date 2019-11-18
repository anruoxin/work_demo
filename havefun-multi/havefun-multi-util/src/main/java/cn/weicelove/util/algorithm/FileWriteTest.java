package cn.weicelove.util.algorithm;

import cn.weicelove.util.algorithm.Test.Consumer;
import cn.weicelove.util.file.FileUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/10/31 22:22
 */
public class FileWriteTest {

    private static volatile boolean beEnd = false;

    private static Logger log = LoggerFactory.getLogger(Test.class);

    private static List<String> types = new ArrayList<>(Arrays.asList("app", "txt", "jpg", "png", "asg"));

    private static List<String> subTypes = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff", "gg",
            "hh", "ii", "jj", "kk"));

    private static Map<Integer, List<String>> data;

    private static List<Integer> ids;

    private static final Integer sum = 80000;

    static {
        ids = new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            ids.add(i);
        }
        data = new HashMap<>();
        for (int i = 0; i < sum; i++) {
            List<String> type = new ArrayList<>();

            int typeSum = new Random().nextInt(3) + 3;
            for (int i1 = 0; i1 < typeSum; i1++) {
                JSONObject typeString = new JSONObject();
                JSONObject subTypeString = new JSONObject();
                int subTypeSum = new Random().nextInt(3) + 3;
                for (int i2 = 0; i2 < subTypeSum; i2++) {
                    subTypeString.put(generateSubTypeNames(), i2);
                }
                typeString.put(generateTypeNames(), subTypeString);
                type.add(typeString.toJSONString());
            }
            data.put(i, type);
        }
    }

    private static String generateTypeNames() {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1; i++) {
            stringBuffer.append(types.get(new Random().nextInt(4)));
        }
        return stringBuffer.toString();
    }

    private static String generateSubTypeNames() {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 1; i++) {
            stringBuffer.append(subTypes.get(new Random().nextInt(10)));
        }
        return stringBuffer.toString();
    }

    private static Map<String, LinkedBlockingQueue> typeMap = new HashMap<>();

    public static void main(String[] args) {
        // 读入所有id

        ExecutorService executorService = Executors.newFixedThreadPool(15);

        for (Integer id : data.keySet()) {
            Map<String, Set<String>> fileNames = new HashMap<>();
            // 从文本中获取id 对应的所有的类型
            List<String> types = data.get(id);
            for (String type : types) {

                // 将类型转换为json，读取类型中所有的键值对
                JSONObject typeJson = JSONObject.parseObject(type);

                for (String fileTypeName : typeJson.keySet()) {

                    LinkedBlockingQueue idValues = typeMap.get(fileTypeName);
                    if (idValues == null) {
                        idValues = new LinkedBlockingQueue<>();
                        executorService.submit(new Consumer(fileTypeName, "c:/root", idValues));
                        typeMap.put(fileTypeName, idValues);
                    }

                    write(fileTypeName, typeJson.getJSONObject(fileTypeName), fileNames);
                }
            }
            executorService.submit(new Product(fileNames, id));
        }

        beEnd = true;

    }

    public static void write(String fileName, JSONObject data, Map<String, Set<String>> fileNames) {
        Set<String> name = fileNames.get(fileName);
        if (name == null) {
            name = new HashSet<>();
        }
        name.addAll(data.keySet());
        fileNames.put(fileName, name);
    }

    static class Product implements Runnable {

        private Map<String, Set<String>> fileName;

        private Integer id;

        public Product(Map<String, Set<String>> fileName, Integer id) {
            this.fileName = fileName;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                log.info("读入id 对应的值...");

                    for (String fName : fileName.keySet()) {
                        LinkedBlockingQueue<IdValue> linkedBlockingQueue = typeMap.get(fName);
                        Set<String> strings = fileName.get(fName);
                        for (String string : strings) {
                            IdValue idValue = new IdValue(id, string);
                            linkedBlockingQueue.put(idValue);
                            log.info("存入成功: " + idValue);
                        }
                    }
            } catch (InterruptedException e) {
                log.error("product thread interrupted.", e);
            }
        }
    }

    static class Consumer implements Runnable {

        private String fileName;

        private String filePath;

        private LinkedBlockingQueue<IdValue> data;

        public Consumer(String fileName, String filePath,
                LinkedBlockingQueue<IdValue> data) {
            this.fileName = fileName;
            this.filePath = filePath;
            this.data = data;
        }

        @Override
        public void run() {
            File file = FileUtil.createFile(fileName, ".txt", filePath);
            if (file == null) {
                log.info("文件为空， 写入失败");
                return;
            }
            try (FileWriter fileWriter = new FileWriter(file)) {
                log.info("consumer 写入文件..." + beEnd);
                while (!beEnd || data.size() > 0) {
                    log.info("consumer 开始取值...");
                    IdValue take = data.take();
                    log.info(Thread.currentThread().getName() + ": 开始写入" + take);
                    fileWriter.write(take.toString());
                }
                fileWriter.flush();
                log.info("consumer  文件写入成功.");
            } catch (FileNotFoundException e) {
                log.error("file is not fund.", e);
            } catch (IOException e) {
                log.error("write failed.", e);
            } catch (InterruptedException e) {
                log.error("consumer thread interrupted.", e);
            }
        }

    }

    static class IdValue {

        private Integer id;

        private String value;

        public IdValue(Integer id, String value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return id + "," + value + '\n';
        }
    }

}
