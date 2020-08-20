package 笔试.奇安信;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/8/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 撤销 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().trim().split(" +");
        if(strs.length == 0){
            System.out.println();
        }else{
            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();
            for(String str : strs){
                if("undo".equals(str) ){
                    if(stack1.isEmpty()){
                        continue;
                    }
                    stack2.push(stack1.pop());
                }else if("redo".equals(str)){
                    if(stack2.isEmpty()){
                        continue;
                    }
                    stack1.push(stack2.pop());
                }else{
                    stack1.push(str);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack1.isEmpty()){
                sb.insert(0, stack1.pop());
                sb.insert(0, " ");
            }
            System.out.println(sb.toString().substring(1));
        }
    }
}
