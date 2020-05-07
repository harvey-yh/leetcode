package 二叉树;

/**
 * @author Harvey
 * @date 2020/5/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean res = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                res = TreeHasTree(root1, root2);
            }
            if(!res){
                res = HasSubtree(root1.left, root2);
            }
            if(!res){
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }
    public boolean TreeHasTree(TreeNode root1, TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null || root1.val != root2.val){
            return false;
        }
        return TreeHasTree(root1.left, root2.left) && TreeHasTree(root1.right, root2.right);
    }
}
