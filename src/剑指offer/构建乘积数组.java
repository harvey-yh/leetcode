package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 构建乘积数组 {
    public int[] constructArr(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        /* 从左往右累乘 */
        for (int i = 0, product = 1; i < n; product *= A[i], i++){
            B[i] = product;
        }
        /* 从右往左累乘 */
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
