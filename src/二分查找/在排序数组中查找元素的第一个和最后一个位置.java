package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int left=0, right=nums.length-1;
        int[] result = new int[]{-1,-1};
        while(left <= right){
            int mid = left+(right-left)/2;
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid -1;
            }else{
                if(nums[left] != target){
                    left++;
                }else{
                    result[0] = left;
                }
                if(nums[right] != target){
                    right--;
                }else{
                    result[1] = right;
                }
            }
            if(result[0] != -1 && result[1] != -1){
                break;
            }
        }
        return result;
    }
}
