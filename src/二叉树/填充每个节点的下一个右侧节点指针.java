package 二叉树;

import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        LinkedList<Node> Q = new LinkedList<>();
        Q.add(root);
        while(Q.size() > 0){
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                if(i < size-1){
                    node.next = Q.peek();
                }else{
                    node.next = null;
                }
                if(node.left != null){
                    Q.add(node.left);
                }
                if(node.right != null){
                    Q.add(node.right);
                }
            }
        }
        return root;
    }
}
