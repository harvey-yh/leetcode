package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/17
 * @slogan Drive business with technology, make business generate value.
 */
public class 交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * -----------------------------------------------------------------------------------------------
     * 超时
     */
    static int count = 0;
    public static boolean isInterleave1(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }
        if(s2.length() == 0){
            return s1.equals(s3);
        }
        helper(s1,s2,s3,0,0);
        return count > 0;
    }
    public static void helper(String s1, String s2, String s3, int i, int j){
        if(i == s1.length() && j == s2.length()){
            count++;
        }
        if(i < s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)){
            if(i < s1.length()){
                helper(s1,s2,s3,i+1,j);
            }
            if(j < s2.length()){
                helper(s1,s2,s3,i,j+1);
            }
        }else if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            helper(s1,s2,s3,i+1,j);
        }else if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            helper(s1,s2,s3,i,j+1);
        }
    }

    /**
     * ------------------------------------------------------------------------------------------------------
     */
    boolean[][] dp;

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new boolean[s1.length()+1][s2.length()+1];
        return helper(s1,s2,s3,0,0,0);
    }
    private boolean helper(String s1, String s2, String s3, int i, int j, int k) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (i > s1.length() || j > s2.length() || dp[i][j]) {
            return false;
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && helper(s1,s2,s3,i + 1, j, k + 1)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && helper(s1,s2,s3,i, j + 1, k + 1)) {
            return true;
        }
        dp[i][j] = true;
        return false;
    }
    public static void main(String[] args){
        System.out.println(isInterleave1("aa", "ab", "abaa"));
    }
}
