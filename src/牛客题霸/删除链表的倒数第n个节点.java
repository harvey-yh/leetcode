package 牛客题霸;

/**
 * @author Harvey
 * @date 2020/9/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除链表的倒数第n个节点 {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode p = head, q = head;
        while(--n > 0){
            q = q.next;
        }
        ListNode pre = null;
        while(q.next != null){
            pre = p;
            p = p.next;
            q = q.next;
        }
        if(pre != null){
            pre.next = p.next;
        }else{
            head = head.next;
        }
        return head;

    }
}
