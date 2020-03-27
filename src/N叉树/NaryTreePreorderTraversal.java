package N叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list;
    }
    private void helper(List<Integer> list, Node root){
        if(root == null){
            return;
        }
        list.add(root.val);
        for(Node node : root.children){
            helper(list, node);
        }
    }
}
