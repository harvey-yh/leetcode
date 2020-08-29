package 笔试.滴滴;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 斐波那契数列矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
        } else {
            long[] dp = new long[n * n];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n * n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            long[][] res = new long[n][n];
            int i = 0, j = 0, t = 0;
            int count = n * n - 1;
            int[][] dict = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] visited = new boolean[n][n];
            while (count >= 0) {
                if (j >= n) {
                    j--;
                    i++;
                    t++;
                } else if (i >= n) {
                    i--;
                    j--;
                    t++;
                } else if (j < 0) {
                    j++;
                    i--;
                    t++;
                } else if (i < 0) {
                    i++;
                    j++;
                    t++;
                }
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    res[i][j] = dp[count];
                    count--;
                    i += dict[t % 4][0];
                    j += dict[t % 4][1];
                } else {
                    t++;
                    i += dict[t % 4][0] + dict[(t + 1) % 4][0];
                    j += dict[t % 4][1] + dict[(t + 1) % 4][1];
                }
            }
            for (int x = 0; x < res.length; x++) {
                for (int y = 0; y < res[0].length - 1; y++) {
                    System.out.print(res[x][y] + " ");
                }
                System.out.println(res[x][res[0].length - 1]);
            }
        }
    }
}
