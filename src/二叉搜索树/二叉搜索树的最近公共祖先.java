package 二叉搜索树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //若当前节点为null、p、q之一，直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //若左子树上存在公共节点（返回值非p、q），则函数返回值为左子树返回值，不需再遍历右子树
        //剪枝
        if (left != null && left != q && left != p) {
            return left;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //若左子树、右子树返回值均为非null，则肯定为一个p，一个q，则公共节点为当前节点
        if (left != null && right != null) {
            return root;
        }else {
            //若左子树返回null，则函数返回值为右子树返回值
            //最后一种情况，即左子树返回非null，右子树返回null，则函数返回值为左子树返回值
            return left == null ? right : left;
        }
    }
}
