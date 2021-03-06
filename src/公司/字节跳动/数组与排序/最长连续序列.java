package 公司.字节跳动.数组与排序;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 最长连续序列 {
    /**
     * O(n)解法
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num :nums){
            if(!set.contains(num+1)){
                int tmp = num-1;
                int count = 1;
                while(set.contains(tmp)){
                    count++;
                    tmp--;
                }
                max = max > count ? max : count;
            }
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1, curr = 1;
        for(int i = 1; i <nums.length;i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1] +1){
                    curr+=1;
                }else{
                    max = Math.max(max,curr);
                    curr=1;
                }
            }
        }
        return Math.max(max,curr);
    }

    public void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
