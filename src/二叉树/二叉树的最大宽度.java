package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/7/22
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的最大宽度 {
    /**
     * DFS
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        root.val = 1;
        // 把树的值转为索引值
        dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size(), first = 0, last = 0, k = size;
            while (size-- > 0) {
                TreeNode node = q.remove();
                if (size == k-1) {
                    first = node.val;
                }
                if (size == 0) {
                    last = node.val;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res = Math.max(res, last - first + 1);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val * 2;
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 1;
        }
        dfs(root.left);
        dfs(root.right);
    }


    /**
     * BFS
     * @param root
     * @return
     */
    public int widthOfBinaryTree1(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
    class AnnotatedNode {
        TreeNode node;
        int depth;
        int pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }
}

