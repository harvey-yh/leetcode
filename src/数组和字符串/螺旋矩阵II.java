package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dict = new int[][]{{0, 1}, {1,0}, {0,-1}, {-1,0}};
        // dict索引，即按照那个方向走
        int d = 0;
        // 当前需要放进矩阵中的正整数
        int x = 1;
        int i = 0, j = 0;
        while(x <= n * n){
            // 符合要求，x放进矩阵
            if(i >= 0 && i < n && j>=0 && j < n && res[i][j] == 0){
                res[i][j] = x;
                x++;
            }
            // 下一个位置不符合要求，换个方向
            if(i+dict[d%4][0] < 0 || i+dict[d%4][0] >= n || j+dict[d%4][1]<0 || j+dict[d%4][1] >=n || res[i+dict[d%4][0]][j+dict[d%4][1]] != 0){
                d++;
            }
            // 下一个位置的索引
            i += dict[d%4][0];
            j += dict[d%4][1];
        }
        return res;
    }
}
