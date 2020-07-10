package 二叉树;

/**
 * @author Harvey
 * @date 2020/5/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 另一个树的子树 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }



}
