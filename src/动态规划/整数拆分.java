package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 整数拆分 {
    /**
     * 10
     * 3 * 3 * 4
      * @param n
     * @return
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < Math.sqrt(i)+1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(integerBreak(10));
    }
}
