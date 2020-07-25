package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 完全平方数 {
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = i;
            for(int j=1;i-j*j>=0;j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static int numSquares1(int n) {
        int count = 0;
        for(int i = (int)Math.sqrt(n);i>=0;i--){
            while(n > 0 && i*i < n){
                n -= i*i;
                count++;
            }
            if(n == 0){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(numSquares1(12));
    }
}
