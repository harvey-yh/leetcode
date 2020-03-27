package 字节跳动.链表与树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        //归并排序
        if(head==null || head.next==null) {
            return head;
        }
        ListNode pre=head;
        ListNode post=head.next;
        while(post!=null && post.next!=null){
            pre=pre.next;
            post=post.next.next;
        }

        ListNode tmp=pre.next;
        pre.next=null;
        ListNode node1=sortList(head);
        ListNode node2=sortList(tmp);

        ListNode newN=new ListNode(0);
        ListNode h=newN;
        while(node1!=null && node2!=null){
            if(node1.val<=node2.val){
                ListNode n=node1.next;
                node1.next=null;
                h.next=node1;
                node1=n;
            }else{
                ListNode n=node2.next;
                node2.next=null;
                h.next=node2;
                node2=n;
            }
            h=h.next;
        }
        if(node1!=null){
            h.next=node1;
        }
        if(node2!=null){
            h.next=node2;
        }
        return newN.next;
    }
}
