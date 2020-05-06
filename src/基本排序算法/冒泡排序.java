package 基本排序算法;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 冒泡排序 {
    /**
     * 平均时间复杂度  O(n^2)
     * 空间复杂度 O(1)
     * 稳定
     * @param nums
     */
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < nums.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{8, 5, 3, 2, 4, 9, 1, 7};
        bubbleSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}
