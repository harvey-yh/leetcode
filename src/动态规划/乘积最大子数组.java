package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 乘积最大子数组 {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
