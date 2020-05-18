package 回溯;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/18
 * @slogan Drive business with technology, make business generate value.
 */
public class N皇后II {
    int res = 0;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res++;
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        for (char[] chars : board) {
            if (chars[col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
