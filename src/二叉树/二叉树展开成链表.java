package 二叉树;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树展开成链表 {
    /**
     * 把左子树插在原来右子树的位置，让右子树插在左子树最右节点的下面
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
    public void flatten1(TreeNode root) {
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if(pre != null){
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            }
            pre = temp;
        }
    }
}
