package cn.weicelove.util.algorithm.dp;

import cn.weicelove.util.random.RandomUtil;
import java.util.Scanner;

/**
 * @author QIU PANWEI Create in 2019/11/14 19:53
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n -- > 0) {
            String str = RandomUtil.generateEnglishLetter(1000);
            System.out.println(String.format("原串: %s, 长度: %d ", str, str.length()));
            // String str = scanner.next();
            int []pos = new int[26];
            for (int i = 0; i < pos.length; i++) {
                // 设置初始位置
                pos[i] = -1;
            }
            int pre = 0, now = 0, maxLen = 0, p = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 映射
                int index = c - 'a';
                if (pos[index] == -1 || i - pos[index] > pre) {
                    now = pre + 1;
                } else {
                    now = i - pos[index];
                }
                pos[index] = i;
                if (now >= maxLen) {
                    p = i;
                    maxLen = now;
                }
                pre = now;
            }
            System.out.println(p + ", " + maxLen);
            System.out.println(String.format("最长的串: %s, 长度: %d", str.substring(p - maxLen + 1, p), maxLen));

        }
    }
}
