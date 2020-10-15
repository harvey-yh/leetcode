package 二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉搜索树中第K小的元素 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        int t = 1;
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                if(t == k){
                    return curr.val;
                }
                t++;
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
        return -1;
    }

    /**
     * 递归方法
     */
    int res = 0, t = 0;
    public int kthSmallest1(TreeNode root, int k) {
        order(root, k);
        return res;
    }
    public void order(TreeNode root, int k){
        if(root == null){
            return ;
        }
        order(root.left, k);
        t++;
        if(t == k){
            res = root.val;
            return;
        }
        order(root.right, k);
    }
}
