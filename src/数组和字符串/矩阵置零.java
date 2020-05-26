package 数组和字符串;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Harvey
 * @date 2020/5/25
 * @slogan Drive business with technology, make business generate value.
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        boolean row0 = false, column0 = false;
        // 判断第一行是否有0
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                column0 = true;
            }
        }
        // 判断第一列是否有0
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                row0 = true;
            }
        }
        // 若行或列有一个0，则该行或列的第一位设为0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 按照第一列中是否有0，把对应的列所有数置为0
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        // 按照第一行中是否有0，把对应的行所有数置为0
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        // 原来就第一行就存在0，第一行全部置为0
        if(row0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        // 原来就第一列就存在0，第一列全部置为0
        if(column0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
//        Arrays.stream(matrix).flatMap(c -> Stream.of(c)).map(c -> Arrays.toString(c)).forEach(System.out::println);
    }
}
