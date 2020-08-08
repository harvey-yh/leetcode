package 笔试.跟谁学;

/**
 * @author Harvey
 * @date 2020/8/7
 * @slogan Drive business with technology, make business generate value.
 */
class Node{
    int data;
    Node next;
}

public class 合并列表 {
    public Node mergeTwoLists(Node n1, Node n2){
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }
        if(n1.data > n2.data){
            Node node = n1;
            n1 = n2;
            n2 = node;
        }
        Node p = n1;
        Node q = n2;
        Node x = q.next;
        Node root = n1;

        while(p.next != null && q.next != null){
            if(p.next.data > q.data){
                q.next = p.next;
                p.next = q;
                p = p.next;
                q = x;
                x = x.next;
            }else{
                p = p.next;
            }
        }
        if(p.next == null){
            p.next = q;
        }
        if(q.next == null){
            while(p.next != null){
                if(p.next.data > q.data){
                    q.next = p.next;
                    p.next = q;
                    break;
                }else{
                    p = p.next;
                }
            }
        }
        return root;
    }
}
