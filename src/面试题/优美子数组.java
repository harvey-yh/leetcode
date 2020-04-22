package 面试题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/4/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 优美子数组 {
    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k){
            return 0;
        }
        List<Integer> odd = new ArrayList<>();
        odd.add(-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                odd.add(i);
            }
        }
        odd.add(nums.length);
        if(odd.size()-2 < k){
            return 0;
        }
        int res=0;
        for(int i=1;i<odd.size()-k;i++){
            int j=i+k-1;
            res += (odd.get(i)-odd.get(i-1)) * (odd.get(j+1) - odd.get(j));
        }
        return res;
    }

    /**
     * 找出所有的奇数数字的索引，第一个是-1，最后一个是nums.length
     * 然后优美数组个数就是K个奇数的第一个与之前一个奇数之间的偶数乘以K个奇数的最后一个与之后的一个奇数之间的偶数的累计和
     *
     * 比如 2，2，2，1, 2, 2, 1, 2, 2, 2
     * 奇数的索引分别是  3, 6，加上头尾 -1和nums.length 就是   -1， 3， 6， 10
     * 最后的结果就是   （3-（-1））*（10-6）
     *
     * 数组保存索引比列表快
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubarrays1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k){
            return 0;
        }
        int[] odd = new int[nums.length+2];
        odd[0]=-1;
        int t=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                odd[t++]=i;
            }
        }
        odd[t]=nums.length;
        if(t-2+1 < k){
            return 0;
        }
        int res=0;
        for(int i=1;i<t-k+1;i++){
            int j=i+k-1;
            res += (odd[i]-odd[i-1]) * (odd[j+1] - odd[j]);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(numberOfSubarrays1(new int[]{1,1,2,1,1}, 3));
    }
}
