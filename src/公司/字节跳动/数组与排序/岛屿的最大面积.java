package 公司.字节跳动.数组与排序;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, BFS(grid, i, j));
                }
            }
        }
        return max;
    }
    public int BFS(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int sum = 1;
        sum += BFS(grid, i - 1, j);
        sum += BFS(grid, i + 1, j);
        sum += BFS(grid, i, j - 1);
        sum += BFS(grid, i, j + 1);
        return sum;
    }
}
