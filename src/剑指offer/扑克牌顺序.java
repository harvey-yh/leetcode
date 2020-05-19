package 剑指offer;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 扑克牌顺序 {
    public static boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length < 5){
            return false;
        }
        int[]d = new int[14];
//        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            max = numbers[i] >max ? numbers[i] : max;
            min = numbers[i] <min ? numbers[i] : min;
        }
        if(max - min < 5){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isContinuous(new int[]{0,0,2,4,5,7,8,9}));
    }
}
