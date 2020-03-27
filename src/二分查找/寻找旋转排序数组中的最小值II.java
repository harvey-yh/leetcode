package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找旋转排序数组中的最小值II {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length - 1;
        if (nums[length] > nums[0]) {
            return nums[0];
        }

        int left = 0, right = length;
        while (left < right) {
            // 如果 nums[left] < nums[right] 表示有序返回 nums[0] 即可
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left +(right-left)/2;
            // 如果中间值大于等于右边值，说明反转部分在右边，否则在左边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                // 如果等于中间值，不确定左右时，比如 [1,1,0,1,1,1,1,1] 这种情况，我们只能随机缩减另一边
                if (nums[mid] == nums[left]) {
                    right--;
                } else {
                    right = mid; // 在左半部分
                }
            }
        }
        return nums[left];
    }
}
