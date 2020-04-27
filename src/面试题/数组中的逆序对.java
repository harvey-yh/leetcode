package 面试题;

/**
 * @author Harvey
 * @date 2020/4/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 数组中的逆序对 {

    private static int res = 0;

    /**
     * 利用归并排序计算逆序对
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        int len = nums.length;

        //为了不改变原数组 新copy个数组进行计算
        int[] copy = new int[len];
        System.arraycopy(nums,0,copy,0,copy.length);

        //归并排序
        mergeSort(copy,0,len-1);
        return res;
    }

    /**
     * nums 待排序数组
     * left 当前待排序区间的左下标
     * right 当前待排序区间的右下标
     */
    private static void mergeSort(int[] nums,int left,int right){
        if(left>=right) {
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        int l = left,r=mid+1,cur=0;
        int[] tmp = new int[right-left+1];
        while(l<=mid && r<=right){
            //左边区间数小于等于右边 左边先放入tmp 并更新左边指针
            if(nums[l] <= nums[r]){
                tmp[cur++] = nums[l++];
                //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
                res += r-(mid+1);
            }else{
                tmp[cur++]=nums[r++];
            }
        }
        //如果右边节点先到右区间边界导致上边while退出
        while(l<=mid){
            tmp[cur++]=nums[l++];
            //相对于正常归并排序多出的一个步骤 计算有多少个逆序对
            res+=r-(mid+1);
        }
        while(r<=right){
            tmp[cur++]=nums[r++];
        }

        //将待排序数组 当前排好序的left~right区间重新赋值
        for(int i=0;i<tmp.length;i++){
            nums[left+i]=tmp[i];
        }
    }

    /**
     * ______________________________________________________________________________________________
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums) {
        int len = nums.length;

        //为了不改变原数组 新copy个数组进行计算
        int[] copy = new int[len];
        System.arraycopy(nums,0,copy,0,copy.length);

        return mergeCount(nums, copy,0, nums.length - 1);
    }

    private int mergeCount(int[] nums, int[] copy, int start, int end){
        if(start >= end){
            return 0 ;
        }

        int mid = (start + end) >> 1 ;
        int left = mergeCount(copy, nums, start, mid) ;
        int right = mergeCount(copy, nums, mid + 1 , end) ;
        int count = 0 ;

        //merge()
        int i = mid;//遍历左区域指针
        int j = end;//遍历右区域指针

        int k = end ;//临时区域指针
        while(i >= start && j >= mid + 1){
            if(nums[i] > nums[j]){
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
        System.out.println(count+" "+left + " " + right);
        return count + left + right ;
    }

    public static void main(String[] args){
        System.out.println(reversePairs(new int[]{7,0,6,3,5,4}));
    }
}
