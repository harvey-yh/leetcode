package 数组和字符串;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Harvey
 * @date 2020/6/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 分割数组为连续子序列 {
    public static boolean isPossible(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> queue = map.get(num - 1);
            int value;
            if (queue == null || queue.isEmpty()) {
                value = 1;
            } else {
                value = queue.poll() + 1;
            }
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            map.get(num).add(value);
        }
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet() ){
            for(Integer v : entry.getValue()){
                if(v < 3){
                    return false;
                }
            }
        }
        return true;
//        return map.values().stream().flatMap(Collection::stream).noneMatch(i -> i < 3);
    }
    public static void main(String[] args){
        System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
    }
}
