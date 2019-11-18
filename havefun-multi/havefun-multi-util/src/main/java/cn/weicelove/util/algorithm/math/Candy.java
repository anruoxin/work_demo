package cn.weicelove.util.algorithm.math;

import java.util.Scanner;

/**
 * @author QIU PANWEI Create in 2019/10/12 14:10
 */
public class Candy {

    /**
     *
     *  1 1*[1/1]^1
     *  2 2*[2/1]^1 2*[2/2]^2
     *  3 3*[3/1]^1 3*[3/2]^2 3*[3/3]^3
     *  4 4*[4/1]^1 4*[4/2]^2 4*[4/3]^3 4*[4/4]^4
     *  5 5*[5/1]^1 5*[5/2]^2 5*[5/3]^3 5*[5/4]^4 5*[5/5]^5
     *  ....
     *
     *  可以看成
     *  1 1*[1/1]^1
     *  2 2*[2/1]^1 2*[2/2]^2
     *  3 3*[3/1]^1 3*[2/2]^2 3*[3/3]^3
     *  4 4*[4/1]^1 4*[4/2]^2 4*[3/3]^3 4*[4/4]^4
     *  5 5*[5/1]^1 5*[4/2]^2 5*[3/3]^3 5*[4/4]^4 5*[5/5]^5
     *
     *  网址：https://ac.nowcoder.com/acm/contest/1114/B
     */
    private static final int sum = 3000000 + 10;

    private static final long mod = 1000000000 + 7;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(), ans = 0;
        long [] power = new long[sum];
        for (int i = 1; i <= n; i++) {
            power[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                power[j / i] = power[j / i] * (j / i) % mod;
                // 下标是从i开始的,计算区间的右边的下标
                long rightPos = Math.min(i + j - 1, n);
                long len = (rightPos - j + 1);
                ans += (len * (j + rightPos) / 2) %mod * power[j / i] % mod;
            }
        }
        System.out.println(ans % mod);

    }
}
