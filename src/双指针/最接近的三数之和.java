package 双指针;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/6/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left != right){
                int min = nums[i] + nums[left] + nums[left + 1];
                if(target < min){
                    if(Math.abs(result - target) > Math.abs(min - target)) {
                        result = min;
                    }
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if(target > max){
                    if(Math.abs(result - target) > Math.abs(max - target)) {
                        result = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                // 判断三数之和是否等于target
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if(sum > target){
                    right--;
                    while(left != right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
                else{
                    left++;
                    while(left != right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
            }
            while(i<nums.length-2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if(sum > target) {
                    end--;
                } else if(sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
