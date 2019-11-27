package cn.weicelove.util.algorithm;

import java.util.Scanner;

/**
 * @author QIU PANWEI Create in 2019/11/22 19:10
 */
public class DpTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int y = scanner.nextInt();
        int []a = new int[n + 1];
        int [][] p = new int[n + 1][m + 1];
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                p[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                p[i][j] = scanner.nextInt();
                if (j < y) {
                    p[i][j] += a[i]*j;
                }
            }
        }

        long [][] f = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int i1 = 0; i1 <= k; i1++) {
                if (i1 == 0) {
                    f[i][i1] = 0L;
                } else {
                    if (i == 1 && i1 <= m) {
                        f[i][i1] = p[i][i1];
                    } else {
                        f[i][i1] = 1L * Integer.MAX_VALUE;
                    }
                }
            }
        }

//        for (int j =1 ; j <=n; j++) {
//            for (int i = 1; i <= m; i++) {
//                System.out.print(p[j][i]+ " ");
//            }
//            System.out.println("");
//        }

        for (int i = 2; i <= n; i++) {
            for (int j = k; j >= 0; j--) {
                for (int q = 0; q <= Math.min(m, j); q++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - q] + p[i][q]);
                }
                //System.out.print(f[i][j] + "  ");
            }
            //System.out.println();
        }
        System.out.println(f[n][k]);

    }

}
/*
5 8 10 3
10 20 100 5 1
1 3 5 7 9 11 13 15
2 4 6 8 10 12 14 16
1 2 3 4 5 6 7 8
1 3 6 10 15 21 28 36
10 20 30 40 50 60 70 80
 */