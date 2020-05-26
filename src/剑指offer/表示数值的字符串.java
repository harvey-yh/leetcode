package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/25
 * @slogan Drive business with technology, make business generate value.
 */
public class 表示数值的字符串 {
    public static boolean isNumber(String s) {
        if(s == null || s.trim().equals("")){
            return false;
        }
        char[] str = s.trim().toCharArray();
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == 0 || i == str.length-1) {
                    return false; // e后面一定要接数字
                }
                if (hasE) {
                    return false;  // 不能同时存在两个e
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                if (i == 0 && i == str.length-1) {
                    return false;
                }
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                if(i+1 < str.length && (str[i+1] == 'e' || str[i+1] == 'E')){
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9'){ // 不合法字符
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isNumber(".e1"));
    }
}
