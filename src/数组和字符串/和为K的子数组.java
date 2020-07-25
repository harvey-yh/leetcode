package 数组和字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/7/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 和为K的子数组 {
    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)){
                ret += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ret;
    }
}
