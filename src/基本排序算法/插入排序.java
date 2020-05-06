package 基本排序算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 插入排序 {
    /**
     * 平均时间复杂度  O(n^2)
     * 空间复杂度 O(1)
     * 稳定
     * @param nums
     */
    public static void insertSort(int[] nums){
        //插入排序
        for (int i = 1; i < nums.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{8, 5, 3, 2, 4, 9, 1, 7};
        insertSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
