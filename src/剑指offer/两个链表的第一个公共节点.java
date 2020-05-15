package 剑指offer;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 两个链表的第一个公共节点 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null && pHead2 == null){
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        // 两个链表前面不同的部分长度分别为a,b，相同的尾部长度为n，
        //假设a+n < b+n,p1指向第一个链表，p2指向第二个链表，
        //当p1先走完后，指向链表2的头开始继续走，
        //当p2走完后转向链表1继续走，
        //这样当他们相等时，就是第一个节点，
        //相当于他们都走了a+n+b+n个节点，所以一定会相遇。
        while(p1 != p2) {
            if(p1 != null) {
                p1 = p1.next;
            }
            if(p2 != null) {
                p2 = p2.next;
            }
            if(p1 != p2) {
                if(p1 == null) {
                    p1 = pHead2;
                }
                if(p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }
}
