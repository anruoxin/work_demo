package cn.weicelove.util.algorithm.math;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/1842/A
 * @author QIU PANWEI Create in 2019/11/15 19:50
 */
public class MutilTest {

    private static final long MOD = 998244353L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            int m = scanner.nextInt();
            long cnt = 1, ans = 1;
            for (int i = 2 * m - 1; i >= 1; i -= 2) {
                ans = ans * 2 % MOD;
                cnt = (cnt * pow(ans - 1, i)) % MOD;
            }
            System.out.println(cnt%MOD);
        }
    }

    public static long pow(long m, int n) {
        long ans = 1;
        while(n > 0){
            if((n&1) == 1){
                ans = ans * m % MOD;
            }
            m = m * m % MOD;
            n >>= 1;
        }
        return ans;
    }
}
