package 字节跳动.链表与树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode A = headA, B = headB;
        while(A != B){
            A = A==null? headB : A.next;
            B = B==null? headA : B.next;
        }
        return A;
    }
}
