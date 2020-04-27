package 链表;

import 字节跳动.链表与树.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Harvey
 * @date 2020/4/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (lists == null || len == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        ListNode res = new ListNode(0);
        ListNode p = res;
        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
                System.out.println(node.val);
            }
        }

        while(!pq.isEmpty()){
            p.next = pq.poll();
            System.out.println(p.next.val);
            p=p.next;
            if(p.next != null){
                pq.add(p.next);
            }
        }
        return res.next;
    }
}
