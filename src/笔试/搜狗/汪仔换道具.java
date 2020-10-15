package 笔试.搜狗;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/9/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 汪仔换道具 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     *
     * 4,4,2  3
     * 9 3 3  4
     *
     * 65%
     */
    public static int numberofprize (int a, int b, int c) {
        int[] nums = new int[3];
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
        Arrays.sort(nums);
        int res = nums[0];
        nums[1] -= nums[0];
        nums[2] -= nums[0];
        if(nums[1] > 1 && (nums[2] - nums[1]) / 2 > nums[1]){
            res += nums[1];
            nums[2] -= 3 * nums[1];
        }else{
            while(nums[1] > 1){
                nums[1] -= 2;
                nums[2] -= 2;
                res++;
            }
            if(nums[1] == 1){
                nums[2] -= 2;
                if(nums[2] > 0){
                    nums[1]--;
                    nums[2]--;
                    res++;
                }else{
                    nums[2] += 2;
                }
            }
        }
        while(nums[2] > 0){
            nums[2] -= 4;
            if(nums[2] > 0){
                nums[2]--;
                res++;
            }
        }
        return res;
    }

    /**
     * -------------------------------------------------------------
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int numberofprize1 (int a, int b, int c) {
        int left = Math.min(Math.min(a,b),c);
        int right = Math.max(Math.max(a,b),c);
        while (left <= right){
            int mid = left+(right-left)/2;
            if (check(mid,a,b,c)){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return right;
    }

    private boolean check(int mid, int a, int b, int c) {
        long left=0;
        left = helper(a, mid, left);
        left = helper(b, mid, left);
        left = helper(b, mid, left);
        return left >= 0;
    }
    public long helper(int x, int mid, long left){
        if (x >= mid){
            left += (x-mid);
        }else {
            left -= (2*(mid-x));
        }
        return left;
    }
}
