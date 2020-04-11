package 贪心算法;

import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/4/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 移掉K位数字 {
    /**
     *  num = "1432219", k = 3
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }

        if (ret.length() == 0) {
            return "0";
        }
        return ret.toString();
    }

    public static String removeKdigits1(String num, int k) {
        for (int i = 0; i < k; i++) {
            num = getNext(num);
        }
        return num;
    }

    private static String getNext(String num) {
        int i = 0;
        for (; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                break;
            }
        }
        return formatResult(num.substring(0, i) + num.substring(i + 1));
    }

    private static String formatResult(String num) {
        int i = 0;
        for (; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                break;
            }
        }
        return i == num.length() ? "0" : num.substring(i);
    }

    public static void main(String[] args){
        System.out.println(removeKdigits("12738097123", 2));
    }
}
