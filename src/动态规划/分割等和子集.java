package 动态规划;

import java.util.Arrays;

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

    /**
     * ————————————————————————————————————————————————————————————
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        //0-1背包问题
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }else{
            sum = sum / 2;
        }
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int num : nums){
            for(int i=sum;i>=num;i--){
                dp[i] += dp[i - num];
            }
            if(dp[sum] != 0){
                return true;
            }
        }
        return false;
    }

    /**
     * ————————————————————————————————————————————————————————————
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        int total=0;
        for(int num: nums) {
            total += num;
        }
        if((total & 1) == 1) {
            return false;
        }
        return find(nums, total/2, 0);
    }
    public boolean find(int[] nums, int target, int index){
        if( target == 0) {
            return true;
        }
        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i]==nums[i-1]) {
                continue;
            }
            if(target-nums[i]<0) {
                return false;
            }
            if(find(nums, target-nums[i], i+1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
