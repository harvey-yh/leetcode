package 周赛;

import javax.swing.*;
import java.util.*;

/**
 * @author Harvey
 * @date 2020/6/14
 * @slogan Drive business with technology, make business generate value.
 */
public class 六月十四周赛 {

    /**
     * 5436. 一维数组的动态和
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }

    /**
     * 5437. 不同整数的最少数目
     * @param arr
     * @param k
     * @return
     */
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0 )+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        int res = 0;
        for (Map.Entry<Integer, Integer> e: list) {
            if(e.getValue() <= k){
                res++;
                k-=e.getValue();
            }else{
                break;
            }
        }
        return map.size() - res;
    }

    /**
     * 5438. 制作 m 束花所需的最少天数
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public int minDays(int[] bloomDay, int m, int k) {
        int inf = (int)1e9 + 1;
        int l = 0;
        int r = inf;
        while(l < r){
            int mid = (l + r) / 2;
            if(check(bloomDay, m, k, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l == inf ? -1 : l;
    }

    public boolean check(int[] b, int m, int k, int t){
        int cnt = 0;
        int total = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] > t){
                cnt = 0;
                continue;
            }
            cnt++;
            if(cnt == k){
                total++;
                cnt = 0;
            }
        }
        return total >= m;
    }

    /**
     * 5188. 树节点的第 K 个祖先
     */
    class TreeAncestor {
        private int[][] jump;
        public TreeAncestor(int n, int[] parent) {
            jump = new int[20][n];
            jump[0] = parent;
            for(int i = 0; i + 1 < 20; i++){
                for(int j = 0; j < n; j++){
                    jump[i + 1][j] = jump[i][j] == -1 ? -1 : jump[i][jump[i][j]];
                }
            }
        }

        public int floorLog(int x) {
            return 31 - Integer.numberOfLeadingZeros(x);
        }


        public int find(int node, int k) {
            if(k == 0 || node == -1){
                return node;
            }
            int log = floorLog(k);
            return find(jump[log][node], k - (1 << log));
        }

        public int getKthAncestor(int node, int k) {
            return find(node, k);
        }
    }
}
