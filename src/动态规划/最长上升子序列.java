package 动态规划;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 *
 * 这种类型的题目很容易包装，要看清本质，脱去包装看是不是一个最长上升子序列问题
 */
public class 最长上升子序列 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int res = 0;
        int [] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i=1;i<len;i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS1(int[] nums) {
        int res=0;
        int[] dp = new int[nums.length];
        for(int num:nums){
            int i=0,j=res;
            while(i < j){
                int mid = (i+j)/2;
                if(dp[mid] < num){
                    i = mid+1;
                }else{
                    j = mid;
                }
            }
            dp[i] = num;
            if(i == res) {
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
    }
}
