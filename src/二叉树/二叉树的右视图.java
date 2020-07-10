package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/4/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
            res.add(integers.get(integers.size()-1));

        }
        return res;
    }
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i == size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
