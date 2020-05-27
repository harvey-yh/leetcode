package 回溯;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 单词搜索 {
    int[][] dirs = { {0, -1},{-1, 0}, {0, 1}, {1, 0}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.equals("")) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word.charAt(0) == board[i][j]) {
                    visited[i][j] = true;
                    if(dfs(board, word, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int count, int x, int y) {
        if (count == word.length()) {
            return true;
        }
        for (int i = 0; i < dirs.length; i++) {
            int tx = x + dirs[i][0];
            int ty = y + dirs[i][1];
            if (tx >= board.length || tx < 0 || ty >= board[0].length || ty < 0 || visited[tx][ty] || word.charAt(count) != board[tx][ty]) {
                continue;
            }
            visited[tx][ty] = true;
            if (dfs(board, word, count + 1, tx, ty)) {
                return true;
            }
            visited[tx][ty] = false;
        }
        return false;
    }
}
