package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的层次遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(level.size() != 0){
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for(TreeNode node : level){
                tmp.add(node.val);
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
            }
            level = nextLevel;
            res.add(tmp);
        }
        Collections.reverse(res);
        return res;
    }
}
