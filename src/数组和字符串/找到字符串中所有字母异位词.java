package 数组和字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/7/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 找到字符串中所有字母异位词 {
    /**
     * 超时
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()){
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);
        }
        HashMap<Character, Integer> tmp = new HashMap<>(map);
        for(int i=0;i<=s.length()-p.length();i++){
            if(map.containsKey(s.charAt(i))){
                int count = 0;
                for(int j=i;j<i+p.length();j++){
                    if(tmp.containsKey(s.charAt(j)) && tmp.get(s.charAt(j)) > 0){
                        tmp.put(s.charAt(j),tmp.get(s.charAt(j))-1);
                        count++;
                    }else{
                        break;
                    }
                }
                if(count == p.length()){
                    res.add(i);
                }
                tmp = new HashMap<>(map);
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()){
            return res;
        }
        int[] map = new int[26];
        for(int i=0;i<p.length();i++){
            map[p.charAt(i)-'a'] += 1;
        }
        int[] tmp = new int[26];
        //cur:之前一轮遍历到的不符合的下标位置   count：符合的字母数量
        int cur = 0, count = 0;
        for(int i=0;i<=s.length()-p.length();i++){
            int start = s.charAt(i)-'a';
            if(map[start] != 0){
                int j=cur;
                // 从cur开始遍历，不需要把之前符合的重新遍历一次
                for(;j<i+p.length();j++){
                    int c = s.charAt(j)-'a';
                    // 符合字母异位词情况的加入到tmp数组，并且count+1
                    if(map[c] != 0 && tmp[c] < map[c]){
                        tmp[c] += 1;
                        count++;
                    }else{
                        //当前s中的字母不在p中或者字母数量超了，即不符合字母异位词的情况，把当前遍历到不符合情况的下标j赋给cur
                        //因为下一轮i加一，所以提前把这轮的start位置上的字母从tmp数组中去掉，在count-1
                        cur = j;
                        tmp[start] -= 1;
                        count--;
                        break;
                    }
                }
                //count与p的长度相等时，则满足字母异位词的情况，加入到res中。
                if(count == p.length()){
                    cur = j;
                    tmp[start] -= 1;
                    count--;
                    res.add(i);
                }
            }else{
                cur++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(findAnagrams1("cbaebabacd", "abc"));
    }
}
