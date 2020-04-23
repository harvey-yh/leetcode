package 动态规划;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 计算各个位数不同的数字个数 {
    public static int countNumbersWithUniqueDigits(int n) {
        int table[] = new int[n+1];
        if(n ==0) {
            return 1;
        }
        if(n == 1) {
            return 10;
        }
        if(n == 2) {
            return 91;
        }
        table[0]  = 1;
        table[1]  = 10;
        table[2] =81;
        int res = 91;
        for(int i = 3;i<=n;i++){
            table[i] = table[i-1] * (10 -i +1);
            res += table[i];
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(countNumbersWithUniqueDigits(7));
}
}
