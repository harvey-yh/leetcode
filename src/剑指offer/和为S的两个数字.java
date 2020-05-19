package 剑指offer;

import java.util.ArrayList;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 和为S的两个数字 {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int l = 0, r = array.length-1;
        int product = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        while(l <= r){
            if(array[l] + array[r] == sum){
                if(product > array[l] * array[r]){
                    res.clear();
                    res.add(array[l]);
                    res.add(array[r]);
                    product = array[l] * array[r];
                }
                l++;
            }else if(array[l] + array[r] > sum){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(FindNumbersWithSum(new int[]{1,2,3,4,5}, 7));
    }
}
