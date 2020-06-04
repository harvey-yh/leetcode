package 数学;

/**
 * @author Harvey
 * @date 2020/6/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 两数相除 {
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) {
            divisor = -divisor;
        }
        int result = 0;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = - result;
        }
        return result;
    }
}
