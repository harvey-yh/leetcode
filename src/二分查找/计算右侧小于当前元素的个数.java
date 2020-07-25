package 二分查找;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/7/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 计算右侧小于当前元素的个数 {
    private int[] count;
    private int[] idx;
    private int[] temp;
    private void mergeSort(int[] nums, int start ,int end){
        if(start < end){
            int mid = (start+end) >> 1;
            mergeSort(nums,start ,mid);
            mergeSort(nums,mid+1, end);

            int left = start, right = mid+1;
            int index = start;
            while(left <= mid && right <= end){
                if(nums[idx[left]] <= nums[idx[right]]){
                    temp[index] = idx[right];
                    right++;
                }else{
                    count[idx[left]] += end - right + 1;
                    temp[index] = idx[left];
                    left++;
                }
                index++;
            }
            while(left <= mid){
                temp[index] = idx[left];
                left++;
                index++;
            }
            while(right <= end){
                temp[index] = idx[right];
                right++;
                index++;
            }
            if (end + 1 - start >= 0) {
                System.arraycopy(temp, start, idx, start, end + 1 - start);
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        idx = new int[n];
        count = new int[n];
        temp = new int[n];

        for(int i=0;i<n;i++){
            idx[i] = i;
        }
        mergeSort(nums,0, n-1);
        for (int i = 0; i < n; i++) {
            res.add(i, count[i]);
        }
        return res;
    }
}
