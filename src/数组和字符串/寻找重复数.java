package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
