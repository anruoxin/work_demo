package cn.weicelove.util.algorithm;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author QIU PANWEI Create in 2019/10/12 14:09
 */
public class Test {

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

            int typeSum = new Random().nextInt(3) + 2;
            for (int i1 = 0; i1 < typeSum; i1++) {
                JSONObject typeString = new JSONObject();
                JSONObject subTypeString = new JSONObject();
                int subTypeSum = new Random().nextInt(3) + 3;
                for (int i2 = 0; i2 < subTypeSum; i2++) {
                    subTypeString.put(subTypes.get(new Random().nextInt(10)), i2);
                }
                typeString.put(types.get(new Random().nextInt(4)), subTypeString);
                type.add(typeString.toJSONString());
            }
            data.put(i, type);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(data));
        // 读入所有id
//        for (Integer id : data.keySet()) {
//            dealId(id);
//        }
       // new Thread(new Consumer("test.txt", "c:/root")).start();
    }

    public static void dealId(Integer id) {
        Map<String, Set<String>> fileNames = new HashMap<>();
        // 从文本中获取id 对应的所有的类型
        List<String> types = data.get(id);
        for (String type : types) {
            // 将类型转换为json，读取类型中所有的键值对
            JSONObject typeJson = JSONObject.parseObject(type);
            for (String fileTypeName : typeJson.keySet()) {

                write(fileTypeName, typeJson.getJSONObject(fileTypeName), fileNames);
            }
        }
        fileNames.forEach((k, v) -> System.out.println("id: " + id + ", file: " + k + ", v: " + v));
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

        @Override
        public void run() {
            while (true) {
                System.out.println("ppp");
            }
        }
    }

    static class Consumer implements Runnable {

        private String fileName;

        private String filePath;

        public Consumer(String fileName, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
        }

        @Override
        public void run() {
            File file = null;
            try {
                file = FileUtil.createFile(fileName, "", filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (file == null) {
                return;
            }

            try (FileWriter fileWriter = new FileWriter(file)) {
                int i = 0;
                while (i ++ < 100) {
                    fileWriter.write("123\n");
                }
                fileWriter.flush();
                log.info("文件写入成功.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    class IdValue {

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
