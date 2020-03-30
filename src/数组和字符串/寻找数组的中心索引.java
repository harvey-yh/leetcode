package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找数组的中心索引 {
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int lsum=0, rsum=0;
        for (int i = 0; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            if(lsum == rsum-lsum-nums[i]){
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }
}
