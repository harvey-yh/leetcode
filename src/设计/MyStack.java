package 设计;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/7/25
 * @slogan Drive business with technology, make business generate value.
 */
class MyStack {
    //输入
    Queue<Integer> queue1 ;
    //输出
    Queue<Integer> queue2 ;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
        if(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        Queue tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }
}