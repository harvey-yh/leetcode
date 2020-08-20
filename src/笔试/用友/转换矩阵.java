package 笔试.用友;

/**
 * @author Harvey
 * @date 2020/8/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 转换矩阵 {
    /**
     * 将矩阵的二维数组进行上下翻转处理
     * [[1,2,3],[4,5,6],[7,8,9]]
     * @param matrix int整型二维数组 矩阵
     * @return int整型二维数组
     */
    public static int[][] convert (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int i=0, j=m-1;
        while(i < j){
            for(int k=0;k<n;k++){
                int tmp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = tmp;
            }
            i++;
            j--;
        }

        return matrix;
    }
}
