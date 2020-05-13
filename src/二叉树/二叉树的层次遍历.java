package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的层次遍历 {
    /**
     * 保存节点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return res;
    }

    /**
     * 递归写法-------------------------------------------------------------------------------------------------------
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return res;
        }
        getList(root, 0);
        return res;
    }
    private void getList(TreeNode node, int i) {
        if (node == null) {
            return;
        }
        if (res.size() == i) {
            res.add(new ArrayList<>());
        }
        res.get(i).add(node.val);
        getList(node.left, i+1);
        getList(node.right, i+1);
    }
}
