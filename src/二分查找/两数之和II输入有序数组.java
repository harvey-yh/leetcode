package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 两数之和II输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                return new int[]{++l,++r};
            }
        }
        return new int[]{-1,-1};
    }
}
