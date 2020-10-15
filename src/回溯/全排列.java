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
            res.add(new LinkedList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            backtrack(list, nums);
            list.removeLast();
        }
    }
}
