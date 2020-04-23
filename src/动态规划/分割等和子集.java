package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 分割等和子集 {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums){
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum/2;
        boolean[] dp = new boolean[sum+1];
        dp[0]=true;
        for(int num : nums){
            for(int i=sum;i>=num;i--){
                dp[i] = dp[i - num] || dp[i];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args){
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
