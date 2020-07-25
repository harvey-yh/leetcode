package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 颜色分类 {
    /**
     * 荷兰过国旗三色问题
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0, p2 = nums.length - 1;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }else{
                curr++;
            }
        }
    }
}
