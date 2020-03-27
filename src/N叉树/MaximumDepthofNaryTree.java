package N叉树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class MaximumDepthofNaryTree {
    int ans = 1;
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        helper(root, 1);
        return ans;
    }
    private void helper(Node root, int depth){
        if(root == null){
            return;
        }
        for(Node node : root.children){
            if(node != null){
                ans = Math.max(ans, depth+1);
            }
            helper(node, depth+1);
        }
    }
}
