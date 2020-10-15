package 笔试.网易.第二次;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class abcxyz {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean flag = true;
        //amabc
        int max = 0;
        for(int i=0;i<str.length();i++){
            flag = true;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('x',0);
            map.put('y',0);
            map.put('z',0);
            map.put('a',0);
            map.put('b',0);
            map.put('c',0);
            for(int j=i;j<str.length();j++){
                if(map.containsKey(str.charAt(j))){
                    map.put(str.charAt(j), map.get(str.charAt(j))+1);
                }
                if(helper(map)){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        System.out.println(max);
    }
    public static boolean helper(HashMap<Character, Integer> map){
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0){
                return false;
            }
        }
        return true;
    }
}
