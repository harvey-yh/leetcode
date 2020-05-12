package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        RandomListNode p = pHead;
        // 第一步 扩张链表，根据原始链表的每个节点N创建对应的N’接在N的后面
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            newNode.random = null;
            p.next = newNode;
            p = p.next.next;
        }
        RandomListNode q = pHead;
        // 第二步 设置复制出来的节点的random指针
        while(q != null){
            RandomListNode node = q.next;
            if(q.random != null){
                node.random = q.random.next;
            }
            q = node.next;
        }
        RandomListNode x = pHead;
        // 链表拆分，奇数位置上的节点组成原始链表，偶数位置上的节点组成复制出来的链表
        RandomListNode a = null, b = null;
        if(x != null){
            a = b = x.next;
            x.next = b.next;
            x = x.next;
        }
        while(x != null){
            b.next = x.next;
            b = b.next;
            x.next = b.next;
            x = x.next;
        }
        return a;
    }
}
