package 剑指offer;

import 公司.字节跳动.链表与树.ListNode;

/**
 * @author Harvey
 * @date 2020/5/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除链表中重复的结点 {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode p1, p2;
        p1 = head;
        p2 = head.next;
        while(p2!=null){
            if(p2.next!=null && p2.val == p2.next.val){
                while (p2.next!=null && p2.val == p2.next.val){
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p2.next;
            }else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head.next;
    }
    public boolean match(char[] str, char[] pattern){
        int ns = str.length + 1;
        int np = pattern.length + 1;
        boolean[][] matched = new boolean[ns][np];
        //当s字符串为空的特殊处理

        //f(0, 0)表示s字符串为空，p字符串为空的情形
        matched[0][0] = true;
        //状态转移过程
        for (int i = 0; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if(i > 0 && (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1])) {
                    matched[i][j] = matched[i - 1][j - 1];
                }
                if(pattern[j - 1] == '*') {
                    if(i == 0 || (str[i - 1] != pattern[j - 2] && pattern[j - 2] != '.')) {
                        matched[i][j] = matched[i][j - 2];
                    }else {
                        matched[i][j] = matched[i - 1][j] || matched[i][j - 1] || matched[i][j - 2];
                    }
                }
            }
        }
        return matched[ns - 1][np - 1];
    }
}
