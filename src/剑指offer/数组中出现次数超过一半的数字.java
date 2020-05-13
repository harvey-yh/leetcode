package 剑指offer;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/5/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNumSolution(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++){
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
        }
        int num = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > array.length / 2){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)和 O(1)
     * @return
     */
    public int MoreThanHalfNumSolution1(int[] array) {
        int x = 0, votes = 0, count = 0;
        for(int num : array){
            if(votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : array) {
            if(num == x) {
                count++;
            }
        }
        return count > array.length / 2 ? x : 0;
    }
}
