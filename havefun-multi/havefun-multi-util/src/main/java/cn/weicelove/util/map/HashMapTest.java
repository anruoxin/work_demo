package cn.weicelove.util.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

/**
 * @author QIU PANWEI Create in 2020/1/4 15:37
 */
@Slf4j
public class HashMapTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println(tableSizeFor(33));

        HashSet<Object> objects = new HashSet<>();

        Collections.synchronizedMap(new HashMap<>());
        System.out.println(hash("qqqqqqqqqqqqqqqqq"));
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put(null, 1231231);
        stringIntegerHashMap.put(null, null);
        System.out.println(stringIntegerHashMap.get(null));
    }

    public static final int hash(Object key) {
        int h;
        // key.hashCode()：返回散列值也就是hashcode
        // ^ ：按位异或
        // >>>:无符号右移，忽略符号位，空位都以0补齐
        log.info("h :{}, h >>> 16: {}, h ^ (h >>> 16) : {}", key.hashCode(), key.hashCode() >>> 16, key.hashCode() ^ (key.hashCode() >>> 16) );
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public static final int tableSizeFor(int cap) {
        int n = cap - 1;
        log.info("init : {}", n);
        log.info("n >>> 1 : {}, n: {}, {}", n >>> 1, Integer.toBinaryString(n), Integer.toBinaryString(n >>> 1));
        n |= n >>> 1;
        log.info("n |= n >>> 1 : {}", n);
        log.info("n >>> 2 : {}, n: {}, {}", n >>> 2, Integer.toBinaryString(n), Integer.toBinaryString(n >>> 2));
        n |= n >>> 2;
        log.info("n |= n >>> 2 : {}", n);
        log.info("n >>> 4 : {}, n: {}, {}", n >>> 4, Integer.toBinaryString(n), Integer.toBinaryString(n >>> 4));
        n |= n >>> 4;
        log.info("n |= n >>> 4 : {}", n);
        log.info("n >>> 8 : {}, n: {}, {}", n >>> 8, Integer.toBinaryString(n), Integer.toBinaryString(n >>> 8));
        n |= n >>> 8;
        log.info("n |= n >>> 8 : {}", n);
        log.info("n >>> 16 : {}, n: {}, {}", n >>> 16, Integer.toBinaryString(n), Integer.toBinaryString(n >>> 16));
        n |= n >>> 16;
        log.info("n |= n >>> 16 : {}", n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
