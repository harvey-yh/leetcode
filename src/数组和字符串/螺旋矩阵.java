package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 螺旋矩阵 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = 0;

        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        //从外部向内部遍历，逐层打印数据
        while(i < count) {
            for (int j = i; j < n-i; j++) {
                    res.add(matrix[i][j]);
                }
                for (int j = i+1; j < m-i; j++) {
                    res.add(matrix[j][(n-1)-i]);
                }

                for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
                    res.add(matrix[(m-1)-i][j]);
            }
            for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = spiralOrder(matrix);
        list.stream().forEach(System.out::println);
    }
}
