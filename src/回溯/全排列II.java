package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 全排列II {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 排序的目的是为了判断重复数字是否选过
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(new LinkedList<>(), nums, used);
        return res;
    }
    public void backtrack(LinkedList<Integer> list, int[] nums, boolean[] used){
        if(list.size() == nums.length){
            res.add(new LinkedList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //已经遍历过的就不需要放进来了
            if(used[i]){
                continue;
            }
            //如果当前数跟前一个数相等，判断前一个数是否选择过，是的话跳过，证明前面已经选过重复的数字了
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            //做出选择
            list.add(nums[i]);
            used[i]=true;
            backtrack(list, nums, used);
            //撤销选择
            list.removeLast();
            used[i]=false;
        }
    }
}
