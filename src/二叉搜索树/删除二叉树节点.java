package 二叉搜索树;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除二叉树节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                // 如果该节点的左子树为空，返回该节点的右子树
                TreeNode right = root.right;
                root.right = null;
                return right;
            }
            if (root.right == null) {
                // 如果该节点的右子树为空，返回该节点的左子树
                TreeNode left = root.left;
                root.left = null;
                return left;
            }
            // 如果该节点的左右子树都不为空，则将该节点右子树中的最小元素替代该元素
            TreeNode rMin = minimun(root.right);
            rMin.right = removeMin(root.right);
            rMin.left = root.left;
            root.left = root.right = null;
            return rMin;
        }
    }

    // 返回以 node 为根的最小节点 (传参的时候保证了 node 不为空，这里不进行非空判断)
    private TreeNode minimun(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
    }

    // 删除以 node 为根的最小节点 (传参的时候保证了 node 不为空，这里不进行非空判断)
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

}
