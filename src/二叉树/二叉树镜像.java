package 二叉树;

/**
 * @author Harvey
 * @date 2020/5/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null){
            mirrorTree(root.left);
        }
        if(root.right != null){
            mirrorTree(root.right);
        }
        return root;
    }
}
