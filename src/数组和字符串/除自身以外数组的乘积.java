package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeros = 0, zero_index = 0;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeros++;
                zero_index = i;
            }else{
                product *= nums[i];
            }
        }
        if(zeros > 1){
            return res;
        }else if(zeros == 1){
            res[zero_index] = product;
        }else{
            for(int i=0;i<nums.length;i++){
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}
