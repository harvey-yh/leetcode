package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/3/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 排序数组 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 快排
     */
    public int[] sortArray1(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(nums, lo, hi);
        sort(nums, lo, partition - 1);
        sort(nums, partition + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int base = nums[lo];
        int l = lo;
        int r = hi;
        while (l < r) {
            while (l < r && nums[r] >= base) {
                r--;
            }
            while (l < r && nums[l] <= base) {
                l++;
            }
            swp(nums, l, r);
        }
        swp(nums, lo, r);
        return r;
    }

    private void swp(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
