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

    /**
     * 保存值
     * @param root
     * @return
     */
    public List<Integer> levelOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        while(treeNodes.size() != 0){
            //一个临时list存放下一层node
            ArrayList<TreeNode> treeNodeTmp = new ArrayList<>();
            for (int i = 0; i < treeNodes.size(); i++) {
                TreeNode node = treeNodes.get(i);
                res.add(node.val);
                if (node.left != null) {
                    treeNodeTmp.add(node.left);
                }
                if (node.right != null) {
                    treeNodeTmp.add(node.right);
                }
            }
            //替换临时list
            treeNodes = treeNodeTmp;
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(pRoot);
        int i=1;
        while(treeNodes.size() != 0){
            ArrayList<Integer> levelNodes = new ArrayList<>();
            ArrayList<TreeNode> nextTreeNodes = new ArrayList<>();
            for(TreeNode node : treeNodes){
                levelNodes.add(node.val);
                if(node.left != null){
                    nextTreeNodes.add(node.left);
                }
                if(node.right != null){
                    nextTreeNodes.add(node.right);
                }
            }
            treeNodes = nextTreeNodes;
            if(i % 2 == 0){
                Collections.reverse(levelNodes);
            }
            res.add(levelNodes);
            i++;
        }
        return res;
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null && sequence.length <= 0){
            return false;
        }
        int n = sequence.length;
        return VerifySquenceOfBST(sequence, n);
    }
    public boolean VerifySquenceOfBST(int[] sequence, int length){
        int root = sequence[length-1];
        int i=0;
        for(;i<length-1;i++){
            if(sequence[i] > root){
                break;
            }
        }
        int j=i;
        for(;j<length-1;j++){
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i > 0){
            left = VerifySquenceOfBST(sequence, i);
        }
        boolean right = true;
        if(i < length-1){
            right = VerifySquenceOfBST(sequence, length-i-1);
        }
        return left && right;
    }
}
