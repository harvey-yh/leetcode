package 数组和字符串;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(String str : strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!res.containsKey(key)){
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(str);
        }
        //map的高效遍历方式entrySet
        Iterator iter = res.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>) iter.next();
            list.add(entry.getValue());
        }
        return list;
    }
}
