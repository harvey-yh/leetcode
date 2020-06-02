package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return  new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> levelNode = new ArrayList<>();
        levelNode.add(root);
        int t = 0;
        while(levelNode.size() > 0){
            List<Integer> tmp = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode node : levelNode){
                if(node.left != null){
                    nextLevel.add(node.left);
                }
                if(node.right != null){
                    nextLevel.add(node.right);
                }
                tmp.add(node.val);
            }
            if(t % 2 != 0){
                Collections.reverse(tmp);
            }
            res.add(tmp);
            t++;
            levelNode = nextLevel;
        }
        return res;
    }
}
