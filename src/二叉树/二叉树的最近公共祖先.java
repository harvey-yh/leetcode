package 二叉树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若当前节点为null、p、q之一，直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //若左子树、右子树返回值均为非null，则肯定为一个p，一个q，则公共节点为当前节点
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
}
