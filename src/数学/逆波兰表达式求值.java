package 数学;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(isNum(s)){
                stack.push(Integer.parseInt(s));
            }else if(isSymbol(s)){
                int tmp2 = stack.pop();
                int tmp1 = stack.pop();
                int tmp;
                switch(s){
                    case "+" : tmp = tmp1 + tmp2;stack.push(tmp);break;
                    case "-" : tmp = tmp1 - tmp2;stack.push(tmp);break;
                    case "*" : tmp = tmp1 * tmp2;stack.push(tmp);break;
                    case "/" : tmp = tmp1 / tmp2;stack.push((int)(tmp));break;
                }

            }else{
                return 0;
            }
        }
        return stack.pop();
    }

    public boolean isNum(String s){
        for(int i=0;i<s.length();i++){
            if(s.length() > 1 && s.charAt(0) == '-'){
                continue;
            }
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean isSymbol(String s){
        if(s.length() == 1 && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
            return true;
        }
        return false;
    }
}
