package 二叉搜索树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val<p.val && root.val<q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
