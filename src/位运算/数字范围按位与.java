package 位运算;

/**
 * @author Harvey
 * @date 2020/8/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 数字范围按位与 {
    /**
     * 位移
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    /**
     * Brian Kernighan 算法
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        while(m<n){
            n=n&(n-1);
        }
        return n;
    }
}
