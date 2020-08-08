package 链表;

import 公司.字节跳动.链表与树.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Harvey
 * @date 2020/4/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode res = new ListNode(0);
        ListNode p = res;
        for(ListNode node : lists){
            if(node!=null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            p.next = pq.poll();
            p=p.next;
            if(p.next != null){
                pq.add(p.next);
            }
        }
        return res.next;
    }


    /**
     * ——————————————————————————————————————————————————
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length-1);
    }

    private ListNode solve(ListNode[] arr, int left, int right){
        if(left == right) {
            return arr[left];
        }
        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid+1, right);
        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null) {
            return node2;
        }
        if(node2 == null) {
            return node1;
        }
        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}
