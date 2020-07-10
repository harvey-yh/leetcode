package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树的序列化与反序列化 {
//    private Queue<String> queue;
//    public String serialize(TreeNode root) {
//        return root==null ? "null," : root.val+"," + serialize(root.left) + serialize(root.right);
//    }
//
//    public TreeNode deserialize(String data) {
//        String[] arr = data.split(",");
//        queue = new LinkedList<>();
//        for (String x : arr) {
//            queue.offer(x);
//        }
//        return deserialize(queue);
//    }
//
//    public TreeNode deserialize(Queue <String> queue) {
//        String str = queue.poll();
//        if ("null".equals(str)) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(str));
//        root.left = deserialize(queue);
//        root.right = deserialize(queue);
//        return root;
//    }



    private StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left);
        dfs(root.right);
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            helper(root, Integer.valueOf(arr[i]));
        }
        return root;
    }

    private TreeNode helper(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        } else if (root.val > value) {
            root.left = helper(root.left, value);
        } else {
            root.right = helper(root.right, value);
        }
        return root;
    }
}
