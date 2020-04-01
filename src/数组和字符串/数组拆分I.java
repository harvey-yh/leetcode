package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 数组拆分I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum += nums[i];
        }
        return sum;
    }
}
