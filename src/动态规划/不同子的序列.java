package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 不同子的序列 {
    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        //初始化，如果S不是空串，但是T是空串，出现次数为1
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String[] args){
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
