package 动态规划;

/**
 * @author Harvey
 * @date 2020/9/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, 1) >= 0;
    }
    public int helper(int[] nums, int start, int end, int turn){
        if(start == end){
            return nums[start]*turn;
        }
        int scoreStart = nums[start] * turn + helper(nums, start+1, end, -turn);
        int scoreEnd = nums[end] * turn + helper(nums, start, end-1, -turn);
        return Math.max(scoreStart, scoreEnd);
    }

    public boolean PredictTheWinner1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = nums[i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = nums[i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j-1]);
            }
        }
        return dp[n-1] >= 0;
    }
}
