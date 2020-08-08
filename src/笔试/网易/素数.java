package 笔试.网易;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 素数 {
    /**
     * 牛牛现在有n个正整数的数组a，牛牛可以将其中的每个数a[i]都拆成若干个和为a[i]的正整数，牛牛想知道拆后(也可以一个都不拆)这个数组最多能有多少个素数。
     *
     * 输入描述
     * 第一行一个正整数n表示数组的长度
     * 第二行n个正整数表示a[i]的值
     * 1 <= n <= 1e6，1 <= a[i] <= 1e9
     * 输出描述
     * 拆后数组最多的素数个数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int n = Integer.valueOf(str[0]);
        int[] a = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            res += a[i] / 2;
        }
        System.out.println(res);
    }
}
