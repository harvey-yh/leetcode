package 周赛;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/7/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 七月五号周赛 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr == null || arr.length < 3){
            return false;
        }
        Arrays.sort(arr);
        for(int i=1;i<arr.length-1;i++){
            if(arr[i+1] - arr[i] != arr[i] - arr[i-1]){
                return false;
            }
        }
        return true;
    }


    public static int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for(int x : right){
            ans = Math.max(ans, n - x);
        }
        for(int x : left){
            ans = Math.max(ans, x);
        }
        return ans;
    }


    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp  = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = mat[i][j] +  dp[i][j+1] + dp[i+1][j] - dp[i][j];
            }
        }

        int ct = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int ii=0;ii<=i;ii++){
                    for(int jj=0;jj<=j;jj++){
                        int all = dp[i+1][j+1] - dp[ii][j+1] - dp[i+1][jj] + dp[ii][jj];
                        int v = Math.abs(i-ii+1) * Math.abs(j-jj+1);
                        if(v==all){
                            ct++;
                        }
                    }
                }
            }
        }
        return ct;
    }

    void swap(char[] cs,int i,int j){
        char t = cs[i];
        cs[i] =cs[j];
        cs[j] = t;
    }

    public String minInteger(String num, int k) {
        char[] cs = num.toCharArray();
        int l = cs.length;
        for(int i=0;i<l && k>0;++i){
            int cur = i;
            for(int j=i+1;j<l && j-i<=k;j++){
                if(cs[j]<cs[cur]){
                    cur = j;
                }
            }
            for(int j=cur;j>i && k>0;j--){
                k--;
                swap(cs, j, j-1);
            }
        }
        return new String(cs);
    }
    public static void main(String[] args){
        System.out.println(getLastMoment(4, new int[]{} , new int[]{0,1}));
    }

}
