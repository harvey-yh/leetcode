package 剑指offer;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 矩阵中的路径 {
    static boolean[][] isVisited ;
    public static boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) {
            return false;
        }
        isVisited = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0]) {
                    if (bfs(board, i, j, words, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, int i, int j, char[] words, int index) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || isVisited[i][j] || board[i][j] != words[index]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = bfs(board, i + 1, j, words, index + 1)
                || bfs(board, i - 1, j, words, index + 1)
                || bfs(board, i, j + 1, words, index + 1)
                || bfs(board, i, j - 1, words, index + 1);
        isVisited[i][j] = false;
        return res;
    }

//    /**
//     * 数组形式给出
//     */
//    boolean[] visited ;
//    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
//        if (matrix == null ||rows < 1 || cols < 1 || str == null) {
//            return false;
//        }
//        visited = new boolean[rows * cols];
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<cols;j++){
//                if (bfs(matrix, rows, cols, i, j, str, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public boolean bfs(char[] matrix, int rows, int cols, int i, int j, char[] str, int index){
//        if(index == str.length){
//            return true;
//        }
//        if(i<0 || j<0 || i == rows || j == cols || visited[i*cols+j] || matrix[i*cols+j] != str[index]){
//            return false;
//        }
//        visited[i*cols+j] = true;
//        boolean res = bfs(matrix, rows, cols,i + 1, j, str, index + 1)
//                || bfs(matrix, rows, cols,i - 1, j, str, index + 1)
//                || bfs(matrix, rows, cols, i, j + 1, str, index + 1)
//                || bfs(matrix, rows, cols,i, j - 1, str, index + 1);
//        visited[i*cols+j]  = false;
//        return res;
//    }

    public static void main(String[] args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
