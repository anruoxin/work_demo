package cn.weicelove.util.algorithm.math;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @author QIU PANWEI Create in 2019/10/12 15:11
 */
public class BitSetTest {

    /**
     *
     * 5 6
     * 101101
     * 011011
     * 100110
     * 111000
     * 101111
     * 2
     * 1011_1
     * 1__1__
     */

    private static final int sum = 1000+ 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BitSet[] map = new BitSet[sum];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            map[i] = new BitSet(m);
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    map[i].set(j);
                }
            }
        }
        int q = scanner.nextInt();
        BitSet aBit = new BitSet(m);
        BitSet bBit = new BitSet(m);
        while (q -- > 0) {
            String next = scanner.next();
            aBit.clear();
            bBit.clear();
            for (int i = 0; i < m; i++) {
                if (next.charAt(i) == '_') {
                    aBit.set(i, false);
                    bBit.set(i, false);
                } else if (next.charAt(i) == '0') {
                    aBit.set(i);
                    bBit.set(i, false);
                } else {
                    aBit.set(i);
                    bBit.set(i);
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                BitSet copy = (BitSet)aBit.clone();
                copy.and(map[i]);
                if (copy.equals(bBit)) {
                    ans ++;
                }
            }
            System.out.println(ans);
        }
    }

}
