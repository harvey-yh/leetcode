package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/9/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 快速幂 {
    public static void main(String[] args){
        System.out.println(qmul(1000000000,1000000000));
        System.out.println(qpow(2, 1000000000));
    }
    static int mod = 1000000007;
    static long qmul(long x, long y){
        long res = 0;
        while(y != 0) {
            if((y & 1) > 0) {
                res = (res + x) % mod;
            }
            x = x * 2 % mod;
            y >>= 1;
        }
        return res;
    }

    static long qpow(long x, long y){
        long ret = 1;
        while(y > 0){
            if((y & 1) != 0) {
                ret = qmul(ret, x);
            }
            x = qmul(x, x);
            y >>= 1;
        }
        return ret;
    }
}
