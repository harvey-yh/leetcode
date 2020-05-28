package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/5/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 组合 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        res = new ArrayList<>();
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }

    void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            findCombinations(n, k, i + 1, p);
            p.pop();
        }
    }
}
