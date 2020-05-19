package 剑指offer;

import java.util.BitSet;
import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 孩子们的游戏 {
    public static int LastRemaining_Solution(int n, int m) {
        if(n == 0){
            return -1;
        }
        BitSet bitSet = new BitSet(n);
        bitSet.clear();
        int i = 0;
        while(bitSet.cardinality() < n - 1){
            int t = 0;
            while(t < m-1){
                if(!bitSet.get(i%n)){
                    t++;
                }
                i++;
            }
            while(bitSet.get(i%n)){
                i++;
            }
            bitSet.set(i%n,true);
        }
        //返回bitset中第一个也是唯一一个为false的索引
        return bitSet.nextClearBit(0);
    }

    public static int LastRemaining_Solution1(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
    public static void main(String[] args){
        System.out.println(LastRemaining_Solution(5, 3));
    }
}
