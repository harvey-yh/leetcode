package 基本排序算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 归并排序 {
    /**
     * 平均时间复杂度  O(n*log(n))
     * 空间复杂度 O(n)
     * 稳定
     * @param nums
     */
    private static void mergeSort(int[] nums, int start, int end) {
        //判断拆分的不为最小单位
        if (start < end) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(nums, start, (start + end) / 2);
            mergeSort(nums, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            int index = 0;
            //记录每个小单位的排序结果
            int[] result = new int[end - start + 1];
            //如果拆分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (nums[left] <= nums[right]) {
                    result[index] = nums[left];
                    left++;
                } else {
                    result[index] = nums[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2) {
                result[index] = nums[left];
                left++;
                index++;
            }
            while (right <= end) {
                result[index] = nums[right];
                right++;
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                nums[i] = result[i - start];
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{25, 84, 21, 47, 15, 27, 68, 35, 20};
        mergeSort(nums, 0, nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
