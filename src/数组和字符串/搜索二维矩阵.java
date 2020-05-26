package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for(int i=0;i<matrix.length;i++){
            if(target <= matrix[i][matrix[0].length-1]){
                for(int j=matrix[0].length-1;j>=0;j--){
                    if(target == matrix[i][j]){
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }
}
