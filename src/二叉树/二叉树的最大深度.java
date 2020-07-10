package 二叉树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
