package 二叉树;

/**
 * @author Harvey
 * @date 2020/7/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树直径 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        max += 1;
        height(root);
        return max-1;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(max, left+right+1);
        return Math.max(left, right) + 1;
    }
}
