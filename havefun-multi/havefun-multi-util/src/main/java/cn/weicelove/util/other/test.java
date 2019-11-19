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

    /**
     *
     * 3 3 3
     * -1 3 1 2
     * -1 4 -1 2
     * -1 1 4 2
     * 7
     * 14
     * -9
     *
     *
     * #include <iostream>
     * #include <cstdio>
     * #include <unordered_map>
     * #include <cmath>
     * #include <string>
     * #include <ctime>
     * #include <cstring>
     * #include <algorithm>
     * #include <stack>
     * #include <unordered_set>
     * #include <set>
     * #include <map>
     * #include <sstream>
     * #include <queue>
     * #include <vector>
     * #include <climits>
     * #include <array>
     * #include <chrono>
     * using namespace std;
     * using namespace chrono;
     *
     * const int N = 500005;
     * int ai[N], bi[N], ci[N], ti[N];
     * struct node
     * {
     *     int t;
     *     long long v;
     * };
     * node ni[N];
     *
     * inline char nc()
     * {
     *     static char buf[100000], *p1, *p2;
     *     return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 100000, stdin), p1 == p2) ? EOF : *p1++;
     * }
     * template<class T>
     * inline void read(T &x)
     * {
     *     x = 0; char c = nc(); T f = 1;
     *     while (!isdigit(c)) { if (c == '-')f = -1; c = nc(); }
     *     while (isdigit(c)) x = x * 10 + c - '0', c = nc();
     *     x *= f;
     * }
     *
     * long long helper(int l, int r, int k)
     * {
     *     if (l == r)
     *     {
     *         return k * ni[l].v;
     *     }
     *
     *     swap(ni[rand() % (r - l + 1) + l], ni[r]);
     *     int j = l;
     *     for (int i = l; i < r; ++ i)
     *     {
     *         if (ni[i].v < ni[r].v)
     *         {
     *             swap(ni[i], ni[j]);
     *             ++j;
     *         }
     *     }
     *     swap(ni[r], ni[j]);
     *
     *     long long t = 0;
     *     for (int i = l; i <= j; ++ i)
     *     {
     *         t += ni[i].t;
     *     }
     *     if (t > k)
     *     {
     *         return helper(l, j, k);
     *     }
     *     else
     *     {
     *         long long v = 0;
     *         for (int i = l; i <= j; ++i)
     *         {
     *             v += ni[i].t * ni[i].v;
     *         }
     *         if (t < k)
     *         {
     *             v += helper(j + 1, r, k - t);
     *         }
     *         return v;
     *     }
     * }
     *
     * int main()
     * {
     *     int n, m, k;
     *     scanf("%d%d%d", &n, &m, &k);
     *
     *     for (int i = 0; i < n; ++i)
     *     {
     *         scanf("%d%d%d%d", &ai[i], &bi[i], &ci[i], &ti[i]);
     *     }
     *
     *     for(int i = 1; i <= m; ++ i)
     *     {
     *         long long i1 = i;
     *         long long i2 = i1 * i;
     *         long long i3 = i2 * i;
     * #if 1
     *         for(int j = 0; j < n; ++ j)
     *         {
     *             ni[j].t = ti[j];
     *             ni[j].v = ai[j] * i3 + bi[j] * i2 + ci[j] * i1;
     *         }
     * #endif
     *         printf("%lld\n", helper(0, n - 1, k));
     *     }
     *
     *     return 0;
     * }
     */

    public static void solve() {
        int [][]a = new int[][]{{-1, 3, 1},{-1, 4, -1},{-1, 1, 4}};
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("day: %d 天", i));
            System.out.println(String.format("第一家店: %d 元", a[0][0] * i* i * i + i * i * a[0][1] + i * a[0][2]));
            System.out.println(String.format("第二家店: %d 元", a[1][0] * i* i * i+ i * i * a[1][1] + i * a[1][2]));
            System.out.println(String.format("第三家店: %d 元", a[2][0] * i* i * i+ i * i * a[2][1] + i * a[2][2]));
            System.out.println("==========================================================");
        }
    }



    public static void main(String[] args) {


        solve();
//        String str = "123456789";
//        System.out.println(StringUtils.substring(str, -4, -2));

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
