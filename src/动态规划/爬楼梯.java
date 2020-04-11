package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 爬楼梯 {
    public static int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(climbStairs(21));
    }
}
