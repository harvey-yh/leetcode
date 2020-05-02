package 面试题;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/5/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 无重复字符的最长字串 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int p1 = 0,p2 = 0;
        int max = 0, tmp=0;
        while(p2<s.length()){
            if(!map.containsKey(s.charAt(p2))){
                map.put(s.charAt(p2), p2);
                p2++;
                tmp++;
            }else{
                max = max < tmp ? tmp : max;
                int index = map.get(s.charAt(p2));
                for(int i=p1;map.containsKey(s.charAt(p2))&&i<=map.get(s.charAt(p2));i++){
                    map.remove(s.charAt(i));
                }
                p1 = index+1;
                tmp = p2 - p1;
            }
        }
        return max < tmp ? tmp : max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
