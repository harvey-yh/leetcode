package 设计;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/6/30
 * @slogan Drive business with technology, make business generate value.
 */
//class CQueue {
//    Stack<Integer> A;
//    Stack<Integer> B;
//    public CQueue() {
//        A = new Stack<>();
//        B = new Stack<>();
//    }
//
//    public void appendTail(int value) {
//        A.push(value);
//    }
//
//    public int deleteHead() {
//        while(!A.isEmpty()){
//            B.push(A.pop());
//        }
//        int tmp = B.pop();
//        while(!B.isEmpty()){
//            A.push(B.pop());
//        }
//        return tmp;
//    }
//}
class CQueue {
    LinkedList<Integer> A,B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
        //stack1.addLast(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()) {
            return B.removeLast();
        }
        if(A.isEmpty()) {
            return -1;
        }
        while(!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
