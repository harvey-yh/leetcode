package 二叉搜索树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 存在重复元素III {
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }
        Map<Long, Long> d = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long m = getID(nums[i], w);
            if (d.containsKey(m)) {
                return true;
            }
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w) {
                return true;
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w) {
                return true;
            }
            d.put(m, (long)nums[i]);
            if (i >= k) {
                d.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }
}
