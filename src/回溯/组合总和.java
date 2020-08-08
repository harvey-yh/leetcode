package 回溯;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 组合总和 {
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, 0, target, new LinkedList<>());
        return res;
    }
    public static void backtrack(int[] candidates, int sum, int index, int target, LinkedList<Integer> list){
        if(sum == target){
            res.add(new LinkedList(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if (candidates[i]+sum<=target){
                //做出选择
                list.add(candidates[i]);
                backtrack(candidates, sum+candidates[i], i, target, list);
                //撤销选择
                list.removeLast();
            }
        }
    }


    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2,3,6,7}, 8));
    }
}
