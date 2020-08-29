package 基本排序算法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 快速排序 {

    /**
     * 平均时间复杂度  O(n*log(n))
     * 空间复杂度 O(n*1og(n))
     * 不稳定
     * @param nums
     */
    private static void qucikSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int l=start, r=end;
        int tmp = nums[l];
        while(l < r){
            while(l<r && nums[r] >= tmp){
                r--;
            }
            if(l < r){
                nums[l++] = nums[r];
            }
            while(l<r && nums[l] < tmp){
                l++;
            }
            if(l<r){
                nums[r--] = nums[l];
            }
        }
        nums[l] = tmp;
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        qucikSort(nums, start, l-1);
        qucikSort(nums,l+1, end);
    }

    public static void main(String[] args){
        int[] nums = new int[]{25, 84, 21, 47, 15, 27, 68, 35, 20};
        qucikSort(nums, 0, nums.length-1);
    }

}
