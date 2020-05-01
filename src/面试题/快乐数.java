package 面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/4/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 快乐数 {
    public static boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while(true){
            int tmp = 0;
            while(n>0){
                tmp += Math.pow(n % 10, 2);
                n /= 10;
            }
            n=tmp;
            if(map.containsKey(tmp)){
                return false;
            }else{
                map.put(n,1);
            }
            if(tmp == 1){
                return true;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(isHappy(5));
    }
}
