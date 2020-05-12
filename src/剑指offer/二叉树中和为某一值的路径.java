package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Harvey
 * @date 2020/5/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();
        helper(root, target, res, cur);
        Collections.sort(res, (o1, o2) -> {
            if (o1.size()<o2.size()){
                return 1;
            }else {
                return -1;
            }
        });
        return res;
    }
    public void helper(TreeNode root,int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if(root == null){
            return ;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        helper(root.left, target, res, list);
        helper(root.right, target, res, list);
        list.remove(list.size()-1);
    }
}
