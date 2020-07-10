package 设计;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/7/3
 * @slogan Drive business with technology, make business generate value.
 */
class LRUCache1 {
    int cap;
    HashMap<Integer, Integer> map;
    public LRUCache1(int capacity) {
        this.cap = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }else{
            if(map.size() == this.cap){
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                iterator.next();
                iterator.remove();
            }
        }
        map.put(key, value);
    }
    public static void main(String[] args){
        LRUCache1 cache = new LRUCache1( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println();cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
