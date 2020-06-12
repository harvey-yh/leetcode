package 二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 不同的二叉搜索树II {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);

    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
