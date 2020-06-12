package 二叉搜索树;

/**
 * @author Harvey
 * @date 2020/6/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 恢复二叉搜索树 {
    TreeNode x = null, y = null, pred = null;

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        swap(x, y);
    }

    public void findTwoSwapped(TreeNode root) {
        if (root == null) {
            return;
        }
        findTwoSwapped(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            }else {
                return;
            }
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    public void swap(TreeNode a, TreeNode b){
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
