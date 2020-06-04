package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 硬币 {
    public static int waysToChange(int n) {
        int[] dp = new int[n+1];
        int[] coins = new int[]{1,5,10,25};
        dp[0]=1;
        for(int i=0;i<4;i++){
            for(int j=coins[i];j<=n;j++){
                if (dp[j] + dp[j - coins[i]] > 1000000007){
                    dp[j] = (dp[j] + dp[j - coins[i]])%1000000007;
                } else {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(waysToChange(5));
    }
}
