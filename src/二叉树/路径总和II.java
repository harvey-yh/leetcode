package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 路径总和II {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        // 如果只有根节点或只有叶子结点，则直接放入 res 中
        if (root.left == null && root.right == null && sum == root.val) {
            // 这里使用 new 的形式是因为初始化后,传进来的数据每次都是更新后的 tmp
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, sum - root.val, tmp);
        dfs(root.right, sum - root.val, tmp);
        // 这里利用了回溯的思想:每次回退上一个节点再寻找另一条边的节点作为新路径
        tmp.remove(tmp.size() - 1);
    }
}
