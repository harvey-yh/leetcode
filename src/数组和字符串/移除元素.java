package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int p=0,q=nums.length-1;
        if(nums == null || nums.length == 0){
            return 0;
        }
        while(p <= q){
            if(nums[p] != val){
                p++;
            }else{
                while(q > p && nums[q] == val){
                    q--;
                }
                nums[p] = nums[q];
                p++;
                q--;
            }
            if (q > 0 && nums[q] == val) {
                q--;
            }
        }
        return q+1;
    }
}
