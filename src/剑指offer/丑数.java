package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Harvey
 * @date 2020/5/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 丑数 {
    /**
     * 超时
     */
    static HashMap<Integer, Boolean> map = new HashMap<>();
    public static int GetUglyNumber_Solution(int index) {
        int num = 1;
        int i = 0;
        while(i < index){
            if(isUgly(num)){
                i++;
                map.put(index, true);
            }
            num++;
        }
        num--;
        return num;
    }
    public static boolean isUgly(int num){
        while(num % 2 == 0){
            num /= 2;
            if(map.containsKey(num)){
                return true;
            }
        }
        while(num % 3 == 0){
            num /= 3;
            if(map.containsKey(num)){
                return true;
            }
        }
        while(num % 5 == 0){
            num /= 5;
            if(map.containsKey(num)){
                return true;
            }
        }
        return num == 1 ? true : false;
    }

    /**
     * 不用计算每个值的丑数
     * 相当于换个思路
     * 只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
     * @param index
     * @return
     */
    static int GetUglyNumber_Solution1(int index) {
        if(index <= 0) {
            return 0;
        }
        ArrayList<Integer> list=new ArrayList<>(index);
        list.add(1);
        int i2=0,i3=0,i5=0;
        while(list.size() < index){
            int m2=list.get(i2) * 2;
            int m3=list.get(i3) * 3;
            int m5=list.get(i5) * 5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min == m2) {
                i2++;
            }
            if(min == m3) {
                i3++;
            }
            if(min == m5) {
                i5++;
            }
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args){
        System.out.println(GetUglyNumber_Solution1(1500));
    }
}
