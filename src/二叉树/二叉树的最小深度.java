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
        // 左子树为null，不参与比较
        if(root.left == null && root.right != null){
            return minDepth(root.right)+1;
        }
        // 右子树为null，不参与比较
        if(root.right == null && root.left != null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}
