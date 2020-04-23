package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 零钱兑换II {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int coin  : coins){
            for(int i=coin;i<=amount;i++){
                dp[i] = dp[i]+dp[i-coin];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args){
        System.out.println(change(5, new int[]{1,2,5}));
    }
}
