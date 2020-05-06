package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 剪绳子 {
    public static int cutRope(int target) {
        if(target < 2) return 0;
        if(target == 2) return 1;
        if(target == 3) return 2;
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max;
        for(int i=4;i<=target;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){
                int tmp = dp[j] * dp[i-j];
                if(max < tmp){
                    max = tmp;
                }
                dp[i] = max;
            }
        }
        return dp[target];
    }
    public static int cutRope1(int target) {
        if(target < 2) return 0;
        int[] dp = new int[target+1];
        dp[2] = 1;
        for(int i=3;i<=target;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[target];
    }
    public static void main(String[] args){
        System.out.println(cutRope(10));
    }
}
