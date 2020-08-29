package 笔试.有赞;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/8/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 链表回文检测 {
    public class ListNode {
        int val;
        ListNode next = null;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        List<Integer> res = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            res.add(p.val);
            p = p.next;
        }
        int i=0,j=res.size()-1;
        while(i < j){
            if(!res.get(i).equals(res.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
