package 剑指offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/5/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉搜索树与双向链表 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while(p!=null && p.right != null){
            p = p.right;
        }
        if(left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left != null ? left : pRootOfTree;
    }
}
