package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs==null||strs.length==0) {
            return 0;
        }
        int[][] dp=new int[m+1][n+1];
        for(String str:strs){
            int zeros=0,ones=0;
            for(char c:str.toCharArray()){
                if(c=='1') {
                    ones++;
                }else{
                    zeros++;
                }
            }
            for(int i=m;i>=zeros;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-zeros][j-ones]);
                }
            }
        }
        return dp[m][n];
    }
}
