package 笔试.奇安信;

/**
 * @author Harvey
 * @date 2020/8/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 发工资 {
    public static int CalulateMethodCount (int num_money) {
        int[] dp = new int[num_money+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=num_money;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[num_money];
    }
}
