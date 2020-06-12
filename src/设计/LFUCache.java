package 设计;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class LFUCache {
    HashMap<Integer, Integer> map ;   // 保存key + 索引
    HashMap<Integer, Integer> map1 ;   // 保存key + value
    LinkedList<Integer> list ;   // 保存key
    int count ;
    public LFUCache(int capacity) {
        count = capacity;
        map = new HashMap<>();
        map1 = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int index = map.get(key);
            int value = map1.get(key);
            list.remove(index);
            list.add(key);
            map.put(key, list.indexOf(key));
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            int index = map.get(key);
            map1.put(key, value);
            list.remove(index);
            list.add(key);
            map.put(key, list.indexOf(key));
        }else if(count > 0){
            list.add(key);
            map.put(key, list.indexOf(key));
            map1.put(key, value);
            count--;
        }else{
            int k = list.get(0);
            list.remove(0);
            map.remove(k);
            map1.remove(k);

            list.add(key);
            map.put(key, list.indexOf(key));
            map1.put(key, value);
        }
    }
    public static void main(String[] args){
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }
}
