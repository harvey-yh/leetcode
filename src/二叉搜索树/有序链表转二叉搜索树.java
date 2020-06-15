package 二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 有序链表转二叉搜索树 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    /**
     * 快慢指针找每次递归的根
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root=sortedListToBSTWithBar(head,null);
        return root;

    }

    public TreeNode sortedListToBSTWithBar(ListNode head,ListNode rear){
        if(head==rear){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=rear&&fast.next!=rear){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=sortedListToBSTWithBar(head,slow);
        root.right=sortedListToBSTWithBar(slow.next,rear);
        return root;
    }


    List<Integer> list;

    /**
     * 链表转成列表
     * @param head
     * @return
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null){
            return null;
        }
        list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return subTree(0, list.size()-1);

    }
    public TreeNode subTree(int start, int end){
        if(start > end){
            return null;
        }
        int mid = (end+start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if (start == end) {
            return node;
        }
        node.left = subTree(start, mid-1);
        node.right = subTree(mid+1, end);
        return node;
    }
}
