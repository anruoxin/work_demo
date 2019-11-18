package cn.weicelove.util.algorithm.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QIU PANWEI Create in 2019/10/25 19:58
 */
public class Group {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        long sum = 0;
        int j = 0;
        for (int i = n - k - 1; i >= 0; i --) {
            sum += a[n - j -1] - a[j];
            j ++;
        }
        System.out.println(sum);
    }

}
