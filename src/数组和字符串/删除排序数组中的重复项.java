package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除排序数组中的重复项 {
    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] == nums[left]){
                right++;
            }else{
                nums[left+1] = nums[right];
                left++;
                right++;
            }
        }
        return left+1;
    }
    public static void main(String[] args){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
