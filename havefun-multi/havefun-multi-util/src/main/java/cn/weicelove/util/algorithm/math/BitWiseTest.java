package cn.weicelove.util.algorithm.math;

/**
 * @author QIU PANWEI Create in 2019/10/14 16:00
 */
public class BitWiseTest {

    /**
     * 3 3
     * 123456
     * 123457
     * 123468
     * 557
     * 568
     * 467
     *
     *     scanf("%d%d", &n, &q);
     *     for (int i = 0; i < n; i++) {
     *         int a = 0;
     *         scanf("%s", s);
     *         for (int j = 0; j < 6; j++) {
     *             a |= 1 << (s[j] - '1');
     *         }
     *         ++cnt[a];
     *     }
     *     for (int i = 0; i < 512; i++) {
     *         for (int j = 0; j < 512; j++) {
     *             if (i & j) {
     *                 w[i] += cnt[j];
     *             }
     *         }
     *     }
     *     for (int qq = 0; qq < q; qq++) {
     *         int c[10] = {};
     *         scanf("%s", s);
     *         m = strlen(s);
     *         bool dyf = true;
     *         for (int i = 0; i < m; i++) {
     *             c[s[i] - '1']++;
     *         }
     *         for (int i = 0; i < 512; i++) {
     *             int now = 0;
     *             for (int j = 0; j < 9; j++) {
     *                 if (i >> j & 1) {
     *                     now += c[j];
     *                 }
     *             }
     *             if (w[i] < now) {
     *                 dyf = false;
     *             }
     *         }
     *
     */
    public static void main(String[] args) {

    }

}
