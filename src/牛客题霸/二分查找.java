package 牛客题霸;

/**
 * @author Harvey
 * @date 2020/8/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 二分查找 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        int l=0,r=n-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(a[mid] >= v){
                if(mid-1 >= 0 && a[mid-1] >= v){
                    r = mid-1;
                }else{
                    return mid+1;
                }
            }else{
                l = mid;
            }
        }
        return n+1;
    }
    public static void main(String[] args){
        System.out.println(upper_bound_(100,1,new int[]{2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96}));
    }
}
