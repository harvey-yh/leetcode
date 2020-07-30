package 深度或广度优先搜索;

/**
 * @author Harvey
 * @date 2020/7/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 矩阵中的最长递增路径 {
    int[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        visited = new int[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0) {
                    max = Math.max(max, dfs(i, j, matrix));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (visited[i][j] > 0) {
            return visited[i][j];
        }
        int max = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i - 1, j, matrix));
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] < matrix[i][j]) {
            max = Math.max(max, dfs(i + 1, j, matrix));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j - 1, matrix));
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] < matrix[i][j]) {
            max = Math.max(max, dfs(i, j + 1, matrix));
        }
        visited[i][j] = max + 1;
        return visited[i][j];
    }
}
