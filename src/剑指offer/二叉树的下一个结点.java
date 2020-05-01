package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }
        // 节点有右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else if ( pNode.next != null && pNode.next.left == pNode) {
            // 节点无右子树且该节点为父节点的左子节点
            return pNode.next;
        } else if (pNode.next != null && pNode.next .right == pNode) {
            // 节点无右子树且该节点为父节点的右子节点
            while(pNode.next != null && pNode .next .left != pNode){
                pNode = pNode.next ;
            }
            return pNode.next ;
        }else{
            //节点无父节点 ，即节点为根节点
            return pNode.next ;
        }
    }
}
