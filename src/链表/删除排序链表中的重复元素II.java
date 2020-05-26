package 链表;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=new ListNode(0);
        node.next=head;
        ListNode p1=node,p2=head;
        int count=0;
        while(p1.next!=null){
            while(p2.next!=null && p2.next.val == p1.next.val){
                p2=p2.next;
                count=1;
            }
            if(count==1){
                p1.next=p2.next;
                p2=p2.next;
                count=0;
            }else{
                p1=p2;
                if(p2.next!=null)p2=p2.next;
            }
        }
        return node.next;
    }
}
