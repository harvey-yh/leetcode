package 周赛;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/5/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 五月三十双周赛 {
    /**
     * 5408. 通过翻转子数组使两个数组相等
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length){
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i=0;i<target.length;i++){
            if(target[i] != arr[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 5409. 检查一个字符串是否包含所有长度为 K 的二进制子串
     * @param s
     * @param k
     * @return
     */
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> res = new HashSet<>();
        for(int i = 0;i<=s.length()-k;i++){
            res.add(s.substring(i, i+k));
        }
        return res.size() == Math.pow(2, k);
    }

    /**
     * 5410. 课程安排 IV
     * @param n
     * @param prerequisites
     * @param queries
     * @return
     */
    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] pre = new boolean[n][n];
        List<Boolean> res = new ArrayList<>();
        for(int[] p : prerequisites){
            pre[p[0]][p[1]] = true;
            for (int i = 0; i < pre.length; i++) {
                if (pre[i][p[0]]) {
                    pre[i][p[1]] = true;
                }
            }
        }
        for (int[] query : queries) {
            res.add(pre[query[0]][query[1]]);
        }
        return res;
    }
    public static void main(String[] args){
        // [false,true,false,true,false,false,false]
        System.out.println(checkIfPrerequisite(5, new int[][]{{4,3},{4,1},{4,0},{3,2},{3,1},{3,0},{2,1},{2,0},{1,0}},
                new int[][]{{1,4},{4,2},{0,1},{4,0},{0,2},{1,3},{0,1}}));
    }
}
