package 设计;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/5/25
 * @slogan Drive business with technology, make business generate value.
 */
public class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表头部添加节点 x
         * @param x
         */
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        /**
         * 删除链表中的 x 节点（x 一定存在）
         * @param x
         */
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        /**
         * 删除链表中最后一个节点，并返回该节点
         * @return
         */
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        /**
         * 返回链表长度
         * @return
         */
        public int size() {
            return size;
        }
    }

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        System.out.print("[null,");

        cache.put(2, 2);
        System.out.print("null,");

        int res1 = cache.get(1);
        System.out.print(res1+",");

        cache.put(3, 3);
        System.out.print("null,");

        int res2 = cache.get(2);
        System.out.print(res2+",");

        cache.put(4, 4);
        System.out.print("null,");

        int res4 = cache.get(1);
        System.out.print(res4+",");

        int res5 = cache.get(3);
        System.out.print(res5+",");

        int res6 = cache.get(4);
        System.out.println(res6+",]");

        System.out.println("[null,null,1,null,-1,null,-1,3,4]");
    }

}
//class LRUCache extends LinkedHashMap<Integer, Integer> {
//    int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75f, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}