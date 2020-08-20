package 笔试.贝壳;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 方格染色 {
    /**
     * 如果n或者m是2的倍数的话，可以直接输出2；其他情况可以看n和m的因子，找到最小的因子取个min就可以了
     */
    public static int getMinMul(int n) {
        for (int i = 2; i <= Math.pow(n, 0.5); i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            if (N == 1) {
                System.out.println(getMinMul(M));
            } else if (M == 1) {
                System.out.println(getMinMul(N));
            } else {
                int minMul = Math.min(getMinMul(N), getMinMul(M));
                System.out.println(minMul);
            }
        }
    }
}
