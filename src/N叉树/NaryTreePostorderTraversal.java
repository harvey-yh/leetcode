package N叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class NaryTreePostorderTraversal {

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return list;
    }
    private void helper(Node root){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            helper(node);
        }
        list.add(root.val);
    }
}
