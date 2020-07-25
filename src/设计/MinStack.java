package 设计;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/7/25
 * @slogan Drive business with technology, make business generate value.
 */
public class MinStack {
//    Stack<Integer> a;
//    Stack<Integer> b;
//    /** initialize your data structure here. */
//    public MinStack() {
//        a = new Stack<>();
//        b = new Stack<>();
//    }
//
//    public void push(int x) {
//        a.push(x);
//        if(b.isEmpty() || b.peek() >= x){
//            b.push(x);
//        }
//    }
//
//    public void pop() {
//        if(a.peek().equals(b.peek())){
//            a.pop();
//            b.pop();
//        }else{
//            a.pop();
//        }
//    }
//
//    public int top() {
//        return a.peek();
//    }
//
//    public int getMin() {
//        return b.peek();
//    }

    /**
     * 一个栈实现，每次元素插入栈的时候，如果该元素比最小值还要小，那就把原先的最小值再插入一次栈，再放入该元素，
     * 每次取最小值的时候，栈顶即为最小元素，并且栈顶的下一个为第二小的元素。
     */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public MinStack(){
    }
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
