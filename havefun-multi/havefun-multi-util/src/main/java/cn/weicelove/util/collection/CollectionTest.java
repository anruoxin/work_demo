package cn.weicelove.util.collection;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorCompletionService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author QIU PANWEI Create in 2020/1/3 14:59
 */
@Slf4j
public class CollectionTest {

    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>(
//                Arrays.asList(1, 23, 234234, 345345, 345, 6456, 67, 234, 234, 45657));
//        log.info("原始列表: {}", integers);
//        reverse(integers);
//        rotate(integers, 1);
//        sort(integers);
//        shuffle(integers);
//        sortWithDesc(integers);
//        Integer[] a = integers.toArray(new Integer[0]);
//        Arrays.parallelSort(a);
//        log.info("parallelSort: {}", JSONObject.toJSONString(a));
//
//
//        int[] aa = {1,2,3};
//        List ints = Arrays.asList(aa);
//        log.info("size: {}", ints.size());
//
//        List bb = Arrays.asList(1, 2, 3);
//        log.info("size: {}", bb.size());
//        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2));
//        for (Integer integer : integers) {
//            if (integer == 2) {
//                integers.remove(integer);
//            }
//        }
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("asd");
    }

    /**
     *
     * 反转列表
     * @param list 列表
     * @return void
     * @author QIU PANWEI
     */
    public static void reverse(List<?> list) {
        Collections.reverse(list);
        log.info("reverse后的列表: {}", list);
    }

    /**
     *
     * 旋转
     * @param list 列表
     * @param distance 正数: 将后几个数放前面;
     * @return void
     * @author QIU PANWEI
     */
    public static void rotate(List<?> list, int distance) {
        Collections.rotate(list, distance);
        log.info("rotate后的列表: {}, distance: {}", list, distance);
        Collections.rotate(list, -distance);
        log.info("rotate后的列表: {}, distance: {}", list, -distance);
    }

    /**
     *
     * 排序，升序
     * @param list 列表
     * @return void
     * @author QIU PANWEI
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        Collections.sort(list);
        log.info("sort后的列表: {}", list);
    }

    /**
     *
     * 随机排序
     * @param list 列表
     * @return void
     * @author QIU PANWEI
     */
    public static void shuffle(List<?> list) {
        Collections.shuffle(list);
        log.info("shuffle后的列表: {}", list);
    }

    /**
     *
     * 排序，降序
     * @param list 列表
     * @return void
     * @author QIU PANWEI
     */
    public static void sortWithDesc(List<Integer> list) {
        Collections.sort(list, (Integer a, Integer b) -> b.compareTo(a));
        log.info("sort后的desc列表: {}", list);
    }

}
