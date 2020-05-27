package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除排序数组中的重复项II {
    /**
     * nums = [0,0,0,1,1,1,1,2,3,3]
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{0,0,0,1,1,1,1,2,3,3}));
    }
}
