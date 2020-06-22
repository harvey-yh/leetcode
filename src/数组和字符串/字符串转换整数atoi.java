package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串转换整数atoi {
    public int myAtoi(String str) {
        int m = 0;
        //只有遇到第一个数字或正负号才break
        for(; m < str.length(); m++){
            char ch = str.charAt(m);
            if(ch == '-' || ch == '+') {
                break;
            } else if (ch >= '0' && ch <= '9') {
                break;
            } else if(ch != ' ') {
                return 0;
            }
        }
        if(m >= str.length()){
            return 0;
        }
        int res = 0;
        int k = 1;
        if(str.charAt(m) == '-') {
            k = -1;
            m++;
        }
        else if (str.charAt(m) == '+') {
            m++;
        }
        while(m < str.length()){
            char ch = str.charAt(m++);
            if(ch >= '0' && ch <= '9'){
                //将字符转为整数
                int a = ch - '0';
                //判断正数时是否溢出和负数时是否溢出
                if(k ==  1 && (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 && a > 7))){
                    return Integer.MAX_VALUE;
                }else if(k == -1 && (k * res < Integer.MIN_VALUE / 10 ||
                        (res * k == Integer.MIN_VALUE / 10 && a > 8))){
                    return Integer.MIN_VALUE;
                }
                res = res * 10 + a;
            }else{
                break;
            }
        }
        return res * k;
    }

    /**
     * "4193 with words"
     * @param str
     * @return
     */
    public static int myAtoi1(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int symbol = 1;
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }else if(str.charAt(0) == '-'){
            symbol = -1;
        }else if(str.charAt(0) != '+' && !Character.isDigit(str.charAt(0))){
            return 0;
        }

        long res = 0;
        int i = 0;
        if(str.charAt(0) == '-' ||str.charAt(0) == '+'){
            i++;
        }
        while(i < str.length() && str.charAt(i) != ' '){
            if(!Character.isDigit(str.charAt(i))){
                break;
            }
            res = res * 10 + str.charAt(i) - '0';
            if(symbol == 1 && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(symbol == -1 && -res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return symbol*(int)res;
    }
    public static void main(String[] args){
        System.out.println(myAtoi1("42"));
    }
}
