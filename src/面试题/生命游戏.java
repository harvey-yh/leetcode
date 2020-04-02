package 面试题;

/**
 * @author Harvey
 * @date 2020/4/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 生命游戏 {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    int[][] board;
    int m, n;

    public void gameOfLife(int[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        // 遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 拿到当前位置周围活细胞数量
                int cnt = countAlive(i, j);
                // 1. 活细胞周围八个位置有两个或三个活细胞，下一轮继续活
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    board[i][j] = 3;
                }
                // 2. 死细胞周围有三个活细胞，下一轮复活了
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // 更新结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int countAlive(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            // 如果这个位置为 0，代表当前轮是死的，不需要算进去
            // 如果这个位置为 1，代表当前轮是活得，需要算进去
            // 如果这个位置为 2，代表当前轮是死的（状态10，下一轮是活的），不需要算进去
            // 如果这个位置为 3，代表是当前轮是活的（状态11，下一轮也是活的），需要算进去
            cnt += (board[nx][ny] & 1);
        }
        return cnt;
    }
}
