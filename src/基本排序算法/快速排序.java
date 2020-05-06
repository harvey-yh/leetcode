package 基本排序算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 快速排序 {
    public static void quickSort(int[] nums){
        Partition(nums, 0, nums.length-1);
    }
    /**
     * 平均时间复杂度  O(n*log(n))
     * 空间复杂度 O(1og(n))
     * 不稳定
     * @param nums
     */
    public static void Partition(int[] nums, int low, int high) {
        int tmp;
        int i=low, j=high;
        if(low < high){
            tmp = nums[low];
            while(i!=j){
                while(j>i && nums[j] >= tmp){
                    j--;
                }
                if(i<j){
                    nums[i] = nums[j];
                    i++;
                }
                while(i<j && nums[i] < tmp){
                    i++;
                }
                if(i<j){
                    nums[j] = nums[i];
                    j--;
                }
                nums[i] = tmp;
                Partition(nums, low, i -1);
                Partition(nums, i + 1, high);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{8, 5, 3, 2, 4, 9, 1, 7};
        quickSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
