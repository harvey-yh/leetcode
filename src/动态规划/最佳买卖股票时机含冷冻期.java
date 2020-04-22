package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 最佳买卖股票时机含冷冻期 {
    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            if(i==1){
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
            }else{
                dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
            }
        }
        return dp[prices.length-1][0];
    }
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{6,1,3,2,4,7}));
    }
}
