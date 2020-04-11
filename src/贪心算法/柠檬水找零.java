package 贪心算法;

import java.util.HashMap;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 柠檬水找零 {
    /**
     * 贪心算法
     * 2 ms	42.3 MB
     *
     * @param bills
     * @return
     */
    private boolean greedySolution(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5: five++; break;
                case 10: five--; ten++; break;
                case 20: {
                    if (ten > 0) {
                        ten--; five--;
                    } else {
                        five -= 3;
                    }
                    break;
                }
                default: break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
