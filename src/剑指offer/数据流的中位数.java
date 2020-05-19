package 剑指offer;

import java.util.PriorityQueue;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 数据流的中位数 {
    PriorityQueue<Integer> A = new PriorityQueue<>((n1,n2)->n2-n1);
    PriorityQueue<Integer> B = new PriorityQueue<>();
    public void Insert(Integer num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public Double GetMedian() {
        return A.size() != B.size() ? (double)A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
