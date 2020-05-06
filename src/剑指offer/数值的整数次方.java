package 剑指offer;

import java.math.BigDecimal;

/**
 * @author Harvey
 * @date 2020/5/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 数值的整数次方 {
    public static double Power(double base, int exponent) {
        if(new BigDecimal(0.0).equals(new BigDecimal(base)) && exponent  < 0){
            return 0.0;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        if(exponent < 0){
            base = 1.0/base;
            exponent = -exponent;
        }
        double res = Power(base, exponent >> 1);
        res *= res;
        if((exponent & 1) == 1){
            res *= base;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Power(0,-10));
    }
}
