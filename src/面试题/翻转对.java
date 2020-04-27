package 面试题;

/**
 * @author Harvey
 * @date 2020/4/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 翻转对 {
    /**
     * 执行错误
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length;
        //为了不改变原数组 新copy个数组进行计算
        int[] copy = new int[len];
        System.arraycopy(nums,0,copy,0,copy.length);

        return mergeCount(nums, copy,0, len - 1);
    }
    private static int mergeCount(int[] nums, int[] copy, int start, int end){
        if(start >= end){
            return 0 ;
        }
        int mid = (start + end) >> 1 ;
        int left = mergeCount(copy, nums, start, mid) ;
        int right = mergeCount(copy, nums, mid+1, end) ;
        int count = 0 ;

        //merge()
        int i = mid, j = end, k = end;
        while(i >= start && j >= mid + 1){
            if(nums[i] > 2 *nums[j]){
                count += j - mid ;
                copy[k --] = nums[i --] ;
            }else{
                copy[k --] = nums[j --] ;
            }
        }
        //如果还有剩下没遍历的
        while(i >= start) {
            copy[k --] = nums[i --] ;
        }
        while(j >= mid + 1) {
            copy[k --] = nums[j --] ;
        }
//        System.out.println(count+" "+left + " " + right);

        return count + left + right ;
    }

    public static void main(String[] args){
        System.out.println(reversePairs(new int[]{5,4,3,2,1}));
    }
}
