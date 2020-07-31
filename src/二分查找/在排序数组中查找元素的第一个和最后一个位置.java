package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * 分别用二分法找到左边的边界和右边的边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0){
            return res;
        }
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (l+r) >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        res[0] = nums[l] == target ? l : -1;
        l = 0;
        r = nums.length-1;
        while(l<r){
            int mid = (l+r+1) >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        res[1] = nums[l] == target ? l : -1;
        return res;
    }
}
