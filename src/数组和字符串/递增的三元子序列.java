package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/6/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 递增的三元子序列 {
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        int min=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
        for(int num:nums){
            if(num <= min){
                min = num;
            }else if(num <= second){
                second = num;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(increasingTriplet(new int[]{5,1,5,5,2,5,4}));
    }
}
