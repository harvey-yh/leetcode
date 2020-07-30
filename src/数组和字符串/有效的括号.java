package 数组和字符串;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/7/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
