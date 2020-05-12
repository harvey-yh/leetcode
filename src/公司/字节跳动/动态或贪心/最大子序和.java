package 公司.字节跳动.动态或贪心;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int ans = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
