package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while(treeNodes.size() != 0){
            ArrayList<Integer> integers = new ArrayList<>();
            //一个临时list存放下一层node
            ArrayList<TreeNode> treeNodeTmp = new ArrayList<>();
            for (int i = 0; i < treeNodes.size(); i++) {
                TreeNode node = treeNodes.get(i);
                integers.add(node.val);
                if (node.left != null) {
                    treeNodeTmp.add(node.left);
                }
                if (node.right != null) {
                    treeNodeTmp.add(node.right);
                }
            }
            //替换临时list
            treeNodes = treeNodeTmp;
            res.add(integers);

        }
        return res;
    }
}
