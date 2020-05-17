package 剑指offer;

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
        //归并排序
        mergeSort(nums,0,len-1);
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
    public int reversePairs1(int [] nums) {
        return merge(nums, 0, nums.length - 1);
    }
    int merge(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = merge(arr, start, mid) + merge(arr, mid + 1, end);

        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += arr[i] <= arr[j] ? j - (mid + 1) : 0;
            count %= 1000000007;
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            count %= 1000000007;
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, start, end - start + 1);
        return count;
    }
    public static void main(String[] args){
        System.out.println(reversePairs(new int[]{7,0,6,3,5,4}));
    }
}
