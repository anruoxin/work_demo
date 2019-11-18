package cn.weicelove.util.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang.StringUtils;

/**
 * @author QIU PANWEI Create in 2019/10/22 15:49
 */
public class test {




    public static void main(String[] args) {
        String str = "123456789";
        System.out.println(StringUtils.substring(str, -4, -2));

//        System.out.println(null instanceof JSONObject);
//        System.out.println(JSON.toJSON(null));
        // testDate();
        // testArrayList();
        // testS();
        //ObjectSerializeUtil.serialize(new User("sad"));
    }


    public static void cal() {
        // 1+2+3+...+50


    }

    public static void testDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String d = format.format(c.getTime());
        System.out.println(d);
    }

    private static void testS() {
        byte[] sads = testSerializable(new User("sad"));
        System.out.println(sads);
        Object o = testUnSerializable(sads);
        System.out.println(o);
    }

    private static void testArrayList() {
        String key = "1,2,3";
        List<String> strings = Optional.ofNullable(key)
                .map(test::split).orElse(new ArrayList<>());
        Integer a = strings.size();
        System.out.println(a);
    }

    public static Object testUnSerializable(byte[] data) {
        ByteArrayInputStream byteArrayInputStream = null;
        try(ObjectInputStream objectInputStream =
                new ObjectInputStream(byteArrayInputStream = new ByteArrayInputStream(data))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public static byte[] testSerializable(Object object) {
        if (!(object instanceof Serializable)) {
            throw new UnsupportedOperationException("该实体类未继承序列化接口");
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try(ObjectOutputStream oss = new ObjectOutputStream(byteArrayOutputStream = new ByteArrayOutputStream())) {
            oss.writeObject(object);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class User implements Serializable{
        private String name;

        private Student student = new Student("asd");

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", student=" + student +
                    '}';
        }
    }

    public static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static List<String> split(String key) {
        return Arrays.asList(key.split(","));
    }

}
