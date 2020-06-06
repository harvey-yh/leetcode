package 位运算;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 两整数之和 {
    public int getSum(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        int lower;
        int carrier;
        while (true) {
            lower = a^b;    // 计算低位
            carrier = a&b;  // 计算进位
            if (carrier==0) break;
            a = lower;
            b = carrier<<1;
        }
        return lower;
    }
}
