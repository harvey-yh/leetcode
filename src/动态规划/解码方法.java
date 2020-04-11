package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 解码方法 {
    public static int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = arr[0]=='0' ? 0 : 1;
        if(s.length()<=1) {
            return dp[1];
        }
        for(int i=2;i<=s.length();i++){
            int n = (arr[i-2]-'0')*10+(arr[i-1]-'0');
            if(arr[i-1]=='0' && arr[i-2]=='0'){
                return 0;
            }else if(arr[i-2]=='0'){
                dp[i] = dp[i-1];
            }else if(arr[i-1]=='0'){
                if(n>26) {
                    return 0;
                }
                dp[i] = dp[i-2];
            }else if(n>26){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args){
        System.out.println(numDecodings("110"));
    }
}
