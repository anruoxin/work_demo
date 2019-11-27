package cn.weicelove.util.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author QIU PANWEI Create in 2019/11/20 14:08
 */
public class Test1 {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(123);
        integers.add(234);
        integers.add(134);


        String a = "1,1,2,,,";
        String[] split = a.split(",");
        System.out.println(split.length);

        List<String> strings = Arrays.asList(split);
        ArrayList<Object> objects = new ArrayList<>();
        // ThreadPoolExecutor executor = new ThreadPoolExecutor();
        // ExecutorService executorService = Executors.newCachedThreadPool();

        Math.random();
        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.addAndGet(1L);
    }

}
