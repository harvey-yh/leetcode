package 数学;

/**
 * @author Harvey
 * @date 2020/6/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
