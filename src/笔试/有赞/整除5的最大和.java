package 笔试.有赞;

/**
 * @author Harvey
 * @date 2020/8/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 整除5的最大和 {
    int max = 0;
    public int maxSumDivFive (int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        dfs(nums, 0, 0);
        return max;
    }
    public void dfs(int[] nums, int i, int sum){
        if(i == nums.length){
            return ;
        }
        sum += nums[i];
        if(sum % 5 == 0){
            max = Math.max(max, sum);
        }
        dfs(nums, i+1, sum);
        dfs(nums, i+1, sum-nums[i]);
    }
}
