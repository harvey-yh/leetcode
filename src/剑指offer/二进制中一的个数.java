package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 二进制中一的个数 {
    public int NumberOf1(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
