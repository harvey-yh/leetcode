package 回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 全排列 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(list, nums);
        return res;
    }
    public void backtrack(LinkedList<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new LinkedList(list));

            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(list, nums);
            list.removeLast();
        }
    }
}
