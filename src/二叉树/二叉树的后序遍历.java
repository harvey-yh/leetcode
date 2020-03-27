package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Recursive(root, res);
        return res;
    }
    public void Recursive(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null){
                Recursive(root.left, res);
            }
            if(root.right != null){
                Recursive(root.right, res);
            }
            res.add(root.val);
        }
    }
}
