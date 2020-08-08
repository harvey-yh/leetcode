package 笔试.跟谁学;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/8/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 括号内反转 {
    public static String reverseParentheses(String s){
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    queue.add(stack.pop());
                }
                stack.pop();
                while(!queue.isEmpty()){
                    stack.add(queue.poll());
                }
            }else{
                stack.add(s.charAt(i));
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
