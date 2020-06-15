package 二叉树;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }
        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);
        return Math.min(left_depth, right_depth) + 1;
    }
}
