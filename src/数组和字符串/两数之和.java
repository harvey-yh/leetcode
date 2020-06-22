package 数组和字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/6/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
