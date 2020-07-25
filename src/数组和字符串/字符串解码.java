package 数组和字符串;

import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/5/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串解码 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();

    }

    public static String decodeString1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int right;
        while (s.indexOf(']') >= 0) {
            right = s.indexOf(']');
            int left = right;
            while (s.charAt(left) != '[') {
                left--;
            }
            int x = left - 1;
            int num = 0;
            int times = 1;
            while (x >= 0 && Character.isDigit(s.charAt(x))) {
                num = num + (s.charAt(x) - '0') * times;
                times *= 10;
                x--;
            }
            String tmp = s.substring(left + 1, right);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; i++) {
                sb.append(tmp);
            }
            s = s.replace(s.substring(x + 1, right + 1), sb.toString());
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(decodeString1("2[abc]3[cd]ef"));
    }
}