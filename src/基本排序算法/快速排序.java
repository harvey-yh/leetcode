package 基本排序算法;

import java.util.Arrays;

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
    private static void partition(int[] nums, int low, int high) {
        int i=low, j=high;
        if(low < high){
            int tmp = nums[i];
            while(i!=j){
                while(j>i && nums[j] > nums[i]){
                    j--;
                }
                if(j>i){
                    nums[i] = nums[j];
                    i++;
                }
                while(i<j && nums[i] < nums[j]){
                    i++;
                }
                if(i<j){
                    nums[j] = nums[i];
                    j--;
                }
                nums[i] = tmp;
                partition(nums, low, i-1);
                partition(nums,i+1,high);
            }
        }
    }
    private static void quickSort(int[] nums){
        partition(nums, 0, nums.length-1);
    }
    
    public static void main(String[] args){
        int[] nums = new int[]{8, 5, 3, 2, 4, 9, 1, 7};
        quickSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
