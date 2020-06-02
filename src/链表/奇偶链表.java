package 链表;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/6/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 奇偶链表 {
    /**
     * 2->1->3->5->6->4->7->NULL
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next;
        while(q != null && q.next != null){
            ListNode node = new ListNode(q.next.val);
            node.next = p.next;
            p.next = node;
            p = p.next;
            q.next = q.next.next;
            q = q.next;
        }
        return head;
    }
}
