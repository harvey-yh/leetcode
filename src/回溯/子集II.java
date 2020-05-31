package 回溯;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Harvey
 * @date 2020/5/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 子集II {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            tmp.add(nums[j]);
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args){
    }
}
