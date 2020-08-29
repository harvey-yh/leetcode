package 牛客题霸;

/**
 * @author Harvey
 * @date 2020/8/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        if(head==null) {
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
