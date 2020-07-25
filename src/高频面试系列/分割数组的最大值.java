package 高频面试系列;

/**
 * @author Harvey
 * @date 2020/7/25
 * @slogan Drive business with technology, make business generate value.
 */
public class 分割数组的最大值 {
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for(int num : nums){
            left = Math.max(left, (long)num);
            right += num;
        }
        while(left < right){
            long mid = left + (right - left) / 2;
            if(canFinish(nums, m, mid)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return (int)left;
    }
    private boolean canFinish(int[] nums, int m, long mid){
        long need = 1, sum = 0;
        for(int num : nums){
            if(sum + num > mid){
                need++;
                sum = 0;
            }
            sum += num;
        }
        return need <= m;
    }
}
