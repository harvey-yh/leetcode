package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        //先反转所有数字
        reverse(nums, 0, nums.length - 1);
        //反转前k个数字
        reverse(nums, 0, k - 1);
        //反转后nums.length-k个数字
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 使用环状
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
