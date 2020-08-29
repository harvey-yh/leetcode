package 牛客题霸;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/8/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 设计LRU缓存结构 {
//    LinkedHashMap<Integer,Integer> lruMap = new LinkedHashMap<>();
//    ArrayList<Integer> result = new ArrayList<>();
//    public int[] LRU (int[][] operators, int k) {
//        for(int[] opt:operators){
//            int key = opt[1];
//            switch(opt[0]){
//                case 1: set(key, opt[2], k); break;
//                case 2: get(key); break;
//                default:break;
//            }
//        }
//        return result.stream().mapToInt(Integer::valueOf).toArray();
//    }
//    public void set(int key, int value, int k){
//        if(lruMap.size()<k){
//            lruMap.put(key,value);
//        }else{
//            Iterator ot = lruMap.keySet().iterator();
//            lruMap.remove(ot.next());
//            lruMap.put(key,value);
//        }
//    }
//    public void get(int key){
//        if(lruMap.containsKey(key)){
//            int val = lruMap.get(key);
//            result.add(val);
//            lruMap.remove(key);
//            lruMap.put(key,val);
//        }else{
//            result.add(-1);
//        }
//    }



    public int[] LRU (int[][] operators, int k) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                int key = operator[1];
                int value = operator[2];
                m.put(key, value);
                if (q.contains(key)) {
                    q.remove(key);
                }
                q.offer(key);
                if (q.size() > k) {
                    m.remove(q.poll());
                }
            }else if (operator[0] == 2) {
                int key = operator[1];
                int value = m.getOrDefault(key, -1);
                //当前访问的提到队尾
                if (value != -1) {
                    q.remove(key);
                    q.offer(key);
                }
                //记录返回结果
                res.add(value);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
