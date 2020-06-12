package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/6/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 有效数字 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s=s.trim();

        char[] str = s.toCharArray();
        int[] index = new int[1]; // 此处用数组而不是数字，是方便后边将index作为参数传递
        index[0] = 0;
        boolean isNumeric;  // 用于判断结果
        // 先判断A
        isNumeric = isInteger(str, index);
        // 判断B
        if (index[0] < str.length && str[index[0]] == '.') {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B A. A.B均可以
        }
        // 判断e后面的A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean isInteger(char[] str, int[] index) {
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-')) {
            index[0]++;
        }
        return isUnsignedInteger(str, index);
    }

    private static boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0) {
            index[0]++;
        }
        if (index[0] > start) {
            return true;
        } else {
            return false;
        }
    }
}
