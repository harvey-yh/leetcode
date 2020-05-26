package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums1.length == 0 || nums1.length < m+n){
            return;
        }
        int r1 = m-1, r2 = n-1;
        while(r1 >= 0 && r2 >= 0){
            if(nums1[r1] > nums2[r2]){
                nums1[r1+r2+1] = nums1[r1];
                r1--;
            }else{
                nums1[r1+r2+1] = nums2[r2];
                r2--;
            }
        }
        if(r1 >= 0){
            for(int i = r1;i>=0;i--){
                nums1[i] = nums1[i];
            }
        }
        if(r2 >= 0){
            for(int i = r2;i>=0;i--){
                nums1[i] = nums2[i];
            }
        }
    }
}
