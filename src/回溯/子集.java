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
        backtrack(0, nums, new ArrayList<>());
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

    /**
     * 从前往后遍历，遇到一个数就把当前所有子集加上该数组成新的子集加入到当前子集中，遍历完毕即是所有子集，秒！
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            List<List<Integer>> plusNumbers = new ArrayList<>();
            for(List<Integer> result : res) {
                List<Integer> newNumber = new ArrayList<>(result);
                newNumber.add(nums[i]);
                plusNumbers.add(newNumber);
            }
            res.addAll(plusNumbers);
        } return res;
    }
}
