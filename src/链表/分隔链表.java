package 链表;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while(p != null && p.next != null && p.next.val < x){
            p = p.next;
        }
        ListNode q = p.next;
        while(q != null && q.next != null){
            if(q.next.val < x){
                ListNode node = new ListNode(q.next.val);
                node.next = p.next;
                p.next = node;
                q.next = q.next.next;
                p = p.next;
            }else{
                q = q.next;
            }
        }

        return t.next;
    }
}
