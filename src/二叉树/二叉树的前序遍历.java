package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的前序遍历 {

        public List<Integer> preorderTraversal(TreeNode root){
            List<Integer> res = new ArrayList<>();
            Recursive(root, res);
            return res;
        }
        public void Recursive(TreeNode root, List<Integer> res){
            if(root != null){
                res.add(root.val);
                if(root.left != null){
                    Recursive(root.left, res);
                }
                if(root.right != null){
                    Recursive(root.right, res);
                }
            }
        }
}
