package utils;

import java.math.BigDecimal;

/**
 * @author Harvey
 * @date 2020/5/7
 * @slogan Drive business with technology, make business generate value.
 */
public class double数值判等 {
    public boolean doubleEquals(double num1, double num2){
        double diff = 1E6;
        return num1 - num2 > -diff && num1 - num2 < diff;
    }
}
