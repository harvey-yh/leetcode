package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/6/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 整数反转 {

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int)result;
    }

    public static int reverse1(int x) {
        String res;
        if(x > 0){
            res = new StringBuffer(String.valueOf(x)).reverse().toString();
            String max_integer = String.valueOf(Integer.MAX_VALUE);
            if(res.length() == max_integer.length() && res.compareTo(max_integer) > 0){
                return 0;
            }else{
                return Integer.parseInt(res);
            }
        }else{
            res = new StringBuffer(String.valueOf(x).substring(1)).reverse().toString();
            String min_integer = String.valueOf(Integer.MIN_VALUE).substring(1);
            System.out.println(res + " " + min_integer);
            if(res.length() == min_integer.length() &&  res.compareTo(min_integer) > 0){
                return 0;
            }else{
                if(res.equals(min_integer)){
                    return Integer.MIN_VALUE;
                }
                return -Integer.parseInt(res);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(reverse(-123));
    }
}
