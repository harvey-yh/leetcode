package 链表;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode l = head, r = head;
        while(r != null){
            if(r.val == l.val){
                r = r.next;
            }else{
                l.next = r;
                l = l.next;
                r = r.next;
            }
        }
        if(l.next != null){
            l.next = null;
        }
        return head;
    }
}
