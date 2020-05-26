package 链表;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 反转链表II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node, q = head;
        while(++count < m){
            p = p.next;
            q = q.next;
        }
        while(q != null && q.next != null && count < n){
            ListNode node1 = new ListNode(q.next.val);
            node1.next = p.next;
            p.next = node1;
            q.next = q.next.next;
            count++;
        }
        return node.next;
    }
}
