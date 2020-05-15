package 剑指offer;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
        String[] strs = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(PrintMinNumber(new int[]{3,32,321}));
    }
}
