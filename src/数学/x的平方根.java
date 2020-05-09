package 数学;

/**
 * @author Harvey
 * @date 2020/5/9
 * @slogan Drive business with technology, make business generate value.
 */
public class x的平方根 {
    /**
     * 牛顿迭代法
     * 迭代 x1 = 0.5*(x0 + C/x0)  直到x1 - x0 < 1E-6
     * @param x
     * @return x0
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-6) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }
}
