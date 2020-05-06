package 基本排序算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 选择排序 {
    /**
     * 平均时间复杂度  O(n^2)
     * 空间复杂度 O(1)
     * 不稳定
     * @param nums
     */
    public static void selectSort(int[] nums){
        //选择
        for (int i = 0; i < nums.length; i++) {
            //默认第一个是最小的。
            int min = nums[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = nums[i];
            nums[i] = min;
            nums[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{8, 5, 3, 2, 4, 9, 1, 7};
        selectSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
