package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 旋转图像 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n+1)/2; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
