package 二叉树;

import java.util.HashMap;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 从前序与中序遍历序列构造二叉树 {
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) {
            return null;
        }
        int root = pre[ps];
        int ri = memo.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps+1, ps + ri - is);
        node.right = buildTree(ri + 1, ie, ps + ri - is+1, pe);
        return node;
    }
}
