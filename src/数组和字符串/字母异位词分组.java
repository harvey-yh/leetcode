package 数组和字符串;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] key = str.toCharArray();
            Arrays.sort(key);
            String key1 = String.valueOf(key);
            if(!map.containsKey(key1)){
                map.put(key1,new ArrayList<>() );
            }
            map.get(key1).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
