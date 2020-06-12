package 设计;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class MedianFinder {
    Queue<Integer> maxheap;
    Queue<Integer> minheap;
    int count;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((o1, o2)->o2 - o1);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            return (double) maxheap.peek();
        }
    }
}
