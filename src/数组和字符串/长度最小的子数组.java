package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 长度最小的子数组 {
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public static void main(String[] args){
        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}
