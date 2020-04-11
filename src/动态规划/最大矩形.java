package 动态规划;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 最大矩形 {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length==0){
            return 0;
        }
        int m=matrix.length, n =matrix[0].length, area = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1'){
                    //计算最大宽度并使用它更新dp
                    dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;
                    int width = dp[i][j];
                    //计算[i,j]处右下角的最大面积矩形
                    for(int k = i; k >= 0; k--){
                        width = Math.min(width, dp[k][j]);
                        area = Math.max(area, width * (i - k + 1));
                    }
                }
            }
        }
        return area;
    }

    public int maximalRectangle1(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        //初始化left为可能的最左边边界
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        //将right初始化为可能的最右边边界
        Arrays.fill(right, n);

        int maxarea = 0;
        for(int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // 更新 height和left
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                    left[j]=Math.max(left[j],cur_left);
                }else{
                    height[j] = 0;
                    left[j]=0;
                    cur_left=j+1;
                }
            }
            // 更新 right
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n; cur_right = j;
                }
            }
            // 更新面积
            for(int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args){
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'} };
//        char[][] matrix = new char[][]{{}};
        System.out.println(maximalRectangle(matrix));
    }
}
