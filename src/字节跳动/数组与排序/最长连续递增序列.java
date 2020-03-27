package 字节跳动.数组与排序;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int max = 1, curr = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                curr++;
            }else{
                max = Math.max(max,curr);
                curr=1;
            }
        }
        return Math.max(max,curr);
    }
}
