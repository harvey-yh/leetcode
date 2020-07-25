package 数组和字符串;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //升序排序
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        int i=0;
        for (Map.Entry<Integer, Integer> e: list) {
            res[i] = e.getKey();
            i++;
            if(i >= k){
                break;
            }
        }
        return res;
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        while(list.size() != k){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == 1){
                    list.remove(entry.getKey());
                }
                map.put(entry.getKey(), map.get(entry.getKey())-1);
            }
        }
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
            System.out.println(res[i]);
        }
        return res;
    }
    public static int[] topKFrequent2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(list,(o1,o2)->o2[1] - o1[1]);
        for(int i=0;i<k;i++){
            res[i] = list.get(i)[0];
        }
        return res;

    }

    public static int[] topKFrequent3(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 记录每个元素的频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 按照 map 中元素的频率来创建数组，高频率的元素位于数组最后边
        List<Integer>[] tmp = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 定义 i 来接收每个元素的频率值
            int i = map.get(key);
            if (tmp[i] == null) {
                tmp[i] = new ArrayList<>();
            }
            // 将对应频率的元素放入以频率为下标的数组中
            tmp[i].add(key);
        }
        // 逆向找出前 k 高频率的元素
        for (int i = tmp.length - 1; i >= 0 && res.size() < k; i--) {
            if (tmp[i] == null) {
                continue;
            }
            // 将当前频率下的元素放入结果集 ans 中
            res.addAll(tmp[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        System.out.println(topKFrequent3(new int[]{1,1,1,2,2,3}, 2));
    }
}
