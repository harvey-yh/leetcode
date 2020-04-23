package 动态规划;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 零钱兑换 {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int coin : coins){
            for(int i=coin;i<=amount;i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
    public static void main(String[] args){
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
