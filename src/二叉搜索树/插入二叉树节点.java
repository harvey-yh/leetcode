package 二叉搜索树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 插入二叉树节点 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        if(root == null){
            root = new TreeNode(val);
        }else{
            insert(node, val);
        }
        return root;
    }
    public void insert(TreeNode node, int val){
        if(node.left != null && val < node.val){
            insert(node.left, val);
        }else if(node.right != null && val > node.val){
            insert(node.right, val);
        }
        if(node.left == null && val < node.val) {
            node.left = new TreeNode(val);
        }else if(node.right == null && val > node.val){
            node.right = new TreeNode(val);
        }
    }
}
