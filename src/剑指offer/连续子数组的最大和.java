package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++){
            dp[i] = Math.max(array[i], dp[i-1]+array[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}
