package 二分查找;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length < nums2.length ? nums1.length : nums2.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 1);
        }
        int i=0;
        for (int num : nums2) {
            if(map.containsKey(num)){
                res[i] = num;
                map.remove(num);
                i++;
            }
        }
        return Arrays.copyOfRange(res, 0, i);
    }
}
