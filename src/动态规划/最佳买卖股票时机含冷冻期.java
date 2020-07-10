package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 最佳买卖股票时机含冷冻期 {
    /**
     * 可以看成两种状态：持股和未持股
     * dp[i][0] 表示第i天未持股
     * dp[i][1] 表示第i天持股
     * 第i天未持股的原因：
     *      1）第i天卖出
     *      2）第i-1天就未持股
     * 第i天持股的原因：
     *      1）第i天买入
     *      2）第i-1天就已经持股
     *      注：因为有冷冻期，所以当i=1的时候我们不需要考虑冷冻期，因为之前没有卖的操作，当大于1时，就需要考虑到冷冻期
     * 转化方程：
     * 未持股：
     *      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
     * 持股：
     *      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);    i = 1
     *      dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);    i > 1
     * @param prices
     * @return
     */
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
