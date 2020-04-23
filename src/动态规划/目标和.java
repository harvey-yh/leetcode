package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 目标和 {
    /**
     *  sum(+) - sum(-) = S
     *  使用+的数字和减去使用-的数字和的总和等于S
     *  sum(+) + sum(-) + sum(+) - sum(-) = S + sum(+) + sum(-)
     * 2 * sum(P) = S + sum(nums)
     * 因此只要找到一个子集，令它们都取正号，并且和等于 (S + sum(nums))/2，就证明存在解。
     *
     * @param nums
     * @param S
     * @return
     */
    public static int findSSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < S || (sum+S)%2 == 1){
            return 0;
        }
        S = (S + sum) / 2;
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = S; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[S];
    }
    public static void main(String[] args){
        System.out.println(findSSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
