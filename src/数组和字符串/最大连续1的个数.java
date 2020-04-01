package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 最大连续1的个数 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r=0,count=0,max=0;
        while(l<nums.length &&r<nums.length){
            if(nums[r] == 1){
                count++;
            }else{
                l = r;
                max = max > count ? max : count;
                count=0;
            }
            r++;
        }
        return max > count ? max : count;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
