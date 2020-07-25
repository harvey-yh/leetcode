package 二分查找;

/**
 * @author Harvey
 * @date 2020/7/17
 * @slogan Drive business with technology, make business generate value.
 */
public class 搜索插入位置 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int res = nums.length;
        while(l <= r){
            int mid = l + (r-l) / 2;
            if(nums[mid] >= target){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(searchInsert(new int[]{1,3}, 2));
    }
}
