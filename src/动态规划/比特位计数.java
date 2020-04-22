package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 比特位计数 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for(int i=1;i<=num;i++){
            dp[i] = i%2==1 ? dp[i/2]+1 :dp[i/2];
        }
        return dp;
    }
}
