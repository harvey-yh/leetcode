package 二叉搜索树;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉搜索树迭代器 {
    Stack<TreeNode> stack;
    /**
     * 这里初始化的时候就已经把所有的节点都按顺序保存下来了，所以时间有点长
     * 可以执行next的时候在遍历
     * @param root
     */
    public 二叉搜索树迭代器(TreeNode root) {
        stack = new Stack<>();
        push(root);
    }

    public void push(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            push(node.right);
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
