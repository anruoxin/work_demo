package cn.weicelove.util.algorithm.math;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/1842/B
 *
 * @author QIU PANWEI Create in 2019/11/15 20:38
 */
public class SumTest {

    private static final long MOD = 998244353L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(((n % MOD * pow(2, n - 1)) % MOD + pow(2, n)) % MOD);
        }
    }

    public static long pow(long m, long n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * m % MOD;
            }
            m = m * m % MOD;
            n >>= 1;
        }
        return ans;
    }

}
