package N叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class N叉树的层序遍历 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return res;
        }
        helper(root, 0);
        return res;
    }
    private void helper(Node root, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for(Node node : root.children){
            helper(node, level + 1);
        }
    }
}
