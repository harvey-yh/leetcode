package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median;
        int len1 = nums1.length, len2 = nums2.length, len = len1+len2;
        int j = 0, z = 0;
        int[] numsAll = new int[len];
        for(int i=0;i<len/2+1;i++){
            if(j == len1){
                numsAll[i] = nums2[z];
                z++;
            }else if(z == len2){
                numsAll[i] = nums1[j];
                j++;
            }else if(nums1[j] < nums2[z]){
                numsAll[i] = nums1[j];
                j++;
            }else{
                numsAll[i] = nums2[z];
                z++;
            }
        }
        median = (len)%2!=0 ? numsAll[(len)/2] : (numsAll[(len)/2-1] + numsAll[(len)/2])/2.0;
        return median;
    }
}
