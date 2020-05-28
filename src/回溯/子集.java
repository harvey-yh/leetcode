package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/5/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 子集 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
