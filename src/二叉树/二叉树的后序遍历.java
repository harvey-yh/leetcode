package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的后序遍历 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root == null){
            return res;
        }
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            // 如果没有右孩子或者右孩子被访问过了
            if (root.right == null ||(res.size() != 0 && res.get(res.size() - 1).equals(root.right.val)) ) {
                res.add(root.val);
                root = null;
            }  else {
                s.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
