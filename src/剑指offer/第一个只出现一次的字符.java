package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/5/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        char[] chs = str.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[58];
        for(int i=0;i<chs.length;i++){
//            map.put(chs[i], map.getOrDefault(chs[i], 0)+1);
            map[(int)chs[i]-65] += 1;
        }
        for(int i=0;i<chs.length;i++){
//            if(map.get(chs[i]) == 1){
//                return i;
//            }
            if(map[(int)chs[i]-65] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(FirstNotRepeatingChar("abcdabd"));
    }
}
