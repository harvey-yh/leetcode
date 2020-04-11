package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 不同路径II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n =obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else{
                break;
            }
        }
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j] != 1){
                dp[0][j] = 1;
            }else{
                break;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{1,0}}));
    }
}
