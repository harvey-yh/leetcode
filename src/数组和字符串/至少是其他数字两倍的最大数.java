package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        int max1 = nums[0], max2=0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
                index = i;
            }else if(nums[i] > max2 && nums[i] <= max1){
                max2 = nums[i];
            }
        }
        return max1>=2*max2 ? index : -1;
    }
}
