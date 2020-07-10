package 二叉树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dp(root.left, root.right);
    }
    public boolean dp(TreeNode left, TreeNode right){
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && dp(left.left, right.right) && dp(left.right, right.left);
    }

}
