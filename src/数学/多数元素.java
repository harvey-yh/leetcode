package 数学;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
