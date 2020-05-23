package 位运算;

/**
 * @author Harvey
 * @date 2020/5/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 二的幂 {
    /**
     * 位运算技巧：
     * 获取二进制中最右边的 1：          x & (-x)。
     * 将二进制中最右边的 1 设置为 0：   x & (x - 1)。
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
