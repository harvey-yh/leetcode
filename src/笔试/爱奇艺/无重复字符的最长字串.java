package 笔试.爱奇艺;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 无重复字符的最长字串 {
    /**
     * 无重复字符的最长字串
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0, r=0;
        int max = 0;
        while(r < str.length()){
            char c = str.charAt(r);
            if(!map.containsKey(c)){
                map.put(c, r);
                r++;
            }else if(map.containsKey(c) && map.get(c) >= l){
                l = map.get(c) + 1;
                map.put(c, r);
                r++;
            }
            max = Math.max(max, r-l);
        }
        System.out.println(max);
    }
}
