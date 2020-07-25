package 动态规划;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 戳气球 {

    /**
     * 分治法
     * @param nums
     * @return
     */
    static int[][] cache;
    public static int maxCoins1(int[] nums){
        cache = new int[nums.length][nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length;j++){
                cache[i][j] = -1;
            }
        }

        int result = getMaxCoins(nums,0,nums.length-1);
        return result;
    }
    static int getMaxCoins(int[] nums, int start,int end){
        //结束条件
        if(start <= end){
            if(cache[start][end] != -1) {
                return cache[start][end];
            }
        }
        if(start == end){
            int result = (start-1<0  ? 1 : nums[start-1]) * nums[start] * (end+1>nums.length-1 ? 1 : nums[end+1]);
            return result;
        }
        int i;
        //状态转移方程
        int maxCoins = 0;
        int temp = 0;
        for(i=start; i<=end;i++){
            temp = (start-1<0 ? 1 : nums[start-1])*nums[i]*(end+1>nums.length-1 ? 1 : nums[end+1]) + getMaxCoins(nums,start,i-1) + getMaxCoins(nums,i+1,end);
            maxCoins = Math.max(maxCoins,temp);
        }
        if(end>=start){
            cache[start][end] = maxCoins;
        }
        return maxCoins;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxCoins(int[] nums){
        int dp[][] = new int[nums.length][nums.length];
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0; i<nums.length; i++){
            for(int j = 0;j<nums.length-i;j++){
                fill(dp,nums,j,j+i);
            }
        }
        return dp[0][nums.length-1];
    }
    static void fill(int[][] dp,int nums[],int start,int end){
        int max = 0;
        for(int i=start; i<=end;i++){
            max = Math.max(max,(start-1<0 ? 1 : nums[start-1])*nums[i]*(end+1>nums.length-1 ? 1 : nums[end+1]) + (start>i-1 ? 0 : dp[start][i-1]) + (end < i+1 ? 0 : dp[i+1][end]));
        }
        dp[start][end] = max;
    }

    int[][] dp;
    public int maxCoins2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        System.arraycopy(nums, 1, newNums, 0, nums.length);
        newNums[nums.length+1] = 1;
        dp = new int[nums.length+2][nums.length+2];
        return helper(newNums, 1, nums.length);

    }
    public int helper(int[] newNums, int i, int j){
        if(i > j){
            return 0;
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        for(int k=i;k<=j;k++){
            int left = helper(newNums, i, k-1);
            int right = helper(newNums, k+1, j);
            int sum = newNums[k]*newNums[i-1]*newNums[j+1];
            dp[i][j] = Math.max(dp[i][j], left + right + sum);
        }
        return dp[i][j];
    }

    public int maxCoins3(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        int[][] dp = new int[n+2][n+2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], (dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]));
                }
            }
        }
        return dp[0][n+1];
    }

    public static void main(String[] args){
        System.out.println(maxCoins1(new int[]{3,1,5,8}));
    }
}
