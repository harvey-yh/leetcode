package 二叉搜索树;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long inorder = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //如果下一个节点值比上一个小，那就不是BST
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        TreeNode root = buildTree(0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int ps, int pe, int is, int ie) {
        if(ie < is || pe < ps) {
            return null;
        }
        int root = pre[ps];
        int ri = map.get(root);
        TreeNode node = new TreeNode(root);
        node.left = buildTree(ps+1, ps + ri - is, is, ri - 1);
        node.right = buildTree(ps + ri - is+1, pe, ri + 1, ie);
        return node;
    }


    public boolean isValidBST1(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
