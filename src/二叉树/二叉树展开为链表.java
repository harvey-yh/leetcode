package 二叉树;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
    }
}
