package 贪心算法;

/**
 * @author Harvey
 * @date 2020/4/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 摆动序列 {
    /**
     *  注：可以是非连续的
     *  [1,7,4,9,2,5]
     * @param nums
     * @return
     */
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    /**
     * 找到所有极值点，看情况是否加上首尾两点
     * 结果错误
     * @param nums
     * @return
     */
    public static int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return 0;
        }
        if(n < 2){
            return n;
        }
        int max = 1;
        for(int i=1;i<n-1;i++){
            int a=nums[i]-nums[i-1],b=nums[i+1]-nums[i];
            if(a!=0 && b!=0 && (a^b)>>>31 == 1){
                max++;
            }
        }
        return nums[n-1]!=nums[n-2] ? max+1:max;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,3,3,2,5};
        System.out.println(wiggleMaxLength1(nums));
    }
}
