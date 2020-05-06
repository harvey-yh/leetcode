package 剑指offer;

import java.util.BitSet;

/**
 * @author Harvey
 * @date 2020/5/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 机器人的运动范围 {
    static BitSet visited;
    public static int movingCount(int threshold, int rows, int cols){
        if(rows <= 0 || cols <= 0 || threshold < 0){
            return 0;
        }
        visited = new BitSet(rows * cols);
        visited.clear();
        return bfs(threshold, rows, cols, 0, 0);
    }
    public static int bfs(int threshold, int rows, int cols, int i, int j){
        if(i<0 || i==rows || j<0 || j==cols || getDigitSum(i)+getDigitSum(j) > threshold || visited.get(i*cols+j)){
            return 0;
        }
        visited.set(i*cols+j, true);
        int res  = 1 + bfs(threshold, rows, cols, i-1, j)
                   + bfs(threshold, rows, cols, i+1, j)
                   + bfs(threshold, rows, cols, i, j-1)
                   + bfs(threshold, rows, cols, i, j+1);
        return res;
    }

    public static int getDigitSum(int n){
        int sum=0;
        while(n > 0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(movingCount(18,100,100));
    }
}
