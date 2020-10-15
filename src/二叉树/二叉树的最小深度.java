package 二叉树;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right +1 : Math.min(left, right) + 1;
    }
}
