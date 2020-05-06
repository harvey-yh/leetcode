package 剑指offer;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/5/3
 * @slogan Drive business with technology, make business generate value.
 */
public class MinStack{
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int node) {
        A.push(node);
        if(B.empty() || B.peek() >= node){
            B.push(node);
        }
    }

    public void pop() {
        if(A.peek().equals(B.peek())){
            A.pop();
            B.pop();
        }else{
            A.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
