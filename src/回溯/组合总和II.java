package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 组合总和II {
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtrack(candidates, 0, 0, target, new LinkedList<>(), used);
        return res;
    }
    public static void backtrack(int[] candidates, int sum, int index, int target, LinkedList<Integer> list, boolean[] used){
        if(sum == target){
            res.add(new LinkedList(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(used[i]){continue;}
            if(i>0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            if (candidates[i]+sum<=target){
                //做出选择
                list.add(candidates[i]);
                used[i] = true;
                backtrack(candidates, sum+candidates[i], i, target, list, used);
                //撤销选择
                list.removeLast();
                used[i] = false;
            }
        }
    }
    public static void main(String[] args){
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
