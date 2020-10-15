package 笔试.搜狗;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/9/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 小镇新房 {
    /**
     * 100%
     * @param t
     * @param xa
     * @return
     */
    public static int getHouses (int t, int[] xa) {
        int res = 2;
        int i=0, j=0;
        double[] nums = new double[xa.length];

        while(i < xa.length){
            nums[j] = xa[i] - (xa[i+1]*1.0 / 2);
            nums[j+1] = xa[i] + (xa[i+1]*1.0 / 2);
            j+=2;
            i+=2;
        }
        Arrays.sort(nums);
        i = 1;
        while(i < nums.length-1){
            if(nums[i+1] - nums[i] > t){
                res += 2;
            }else if(nums[i+1] - nums[i] == t){
                res += 2;
            }
            i+=2;
        }
        return res;
    }
}
