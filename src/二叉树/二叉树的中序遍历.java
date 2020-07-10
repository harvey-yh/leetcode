package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
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
        return res;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null){
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null|| !s.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                s.push(root);
                root = root.right;
            }
            root = s.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }
}
