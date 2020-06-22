package 二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/6/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 从先序遍历还原二叉树 {
    /**
     * "1-2--3--4-5--6--7"
     * 非递归
     * @param S
     * @return
     */
    public static TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (S.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            }else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

    /**
     * ---------------------------------------------------------------------------------------------------------------
     * 递归
     */
    int idx;
    public TreeNode recoverFromPreorder1(String S) {
        idx = 0;
        return helper(S,0);
    }

    public TreeNode helper(String S, int depth ) {
        if (idx >= S.length()) {
            return null;
        }
        int curDepth = 0;
        int k = idx;
        while (k < S.length() && S.charAt(k) == '-'){
            curDepth++;
            k++;
        }
        if (curDepth!=depth) {
            return null;
        }
        idx = k;
        int val = 0;
        while (idx < S.length() && Character.isDigit(S.charAt(idx))){
            val = val*10 + (S.charAt(idx) - '0');
            idx++;
        }
        TreeNode node = new TreeNode(val);
        node.left = helper(S,depth+1);
        node.right = helper(S,depth+1);
        return node;
    }
    public static void main(String[] args){
        System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
    }
}
