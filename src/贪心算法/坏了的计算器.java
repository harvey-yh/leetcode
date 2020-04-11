package 贪心算法;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 坏了的计算器 {

    public static int brokenCalc1(int X, int Y) {
        if (Y <= X) {
            return X - Y;
        }
        int cnt1 = 0;
        while (X < Y) {
            X *= 2;
            cnt1 ++;
        }
        if (X == Y) {
            return cnt1;
        }
        int r = X - Y;
        int cnt2 = 0;
        for (int i = cnt1; i >= 0; i--) {
            int t = (int)Math.pow(2, i);
            int coeff = r / t;
            r = r % t;
            cnt2 += coeff;
            if (r == 0) {
                break;
            }
        }
        return cnt1 + cnt2;
    }
    public int brokenCalc2(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
        }

        return ans + X - Y;
    }
    public static void main(String[] args){
        System.out.println(brokenCalc1(1,1000000000));
    }
}
