package 二分查找;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 找出第k小的距离对 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0,  high = nums[n - 1] - nums[0];
        while (low < high) {
            int mi = low +(high - low) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < n; ++right) {
                while (nums[right] - nums[left] > mi) {
                    left++;
                }
                count += right - left;
            }
            if (count >= k) {
                high = mi;
            } else {
                low = mi + 1;
            }
        }
        return low;
    }
}
