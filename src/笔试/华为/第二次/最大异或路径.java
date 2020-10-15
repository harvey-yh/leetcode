package 笔试.华为.第二次;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 最大异或路径 {
    static long result = 0;
    public static class TreeNode{
        int id;
        long value;
        int leftId;
        int rightId;
        TreeNode left;
        TreeNode right;
        public TreeNode(int id, long value, int leftId, int rightId) {
            this.id = id;
            this.value = value;
            this.leftId = leftId;
            this.rightId = rightId;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,TreeNode> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeId = sc.nextInt();
            long nodeValue = sc.nextLong();
            int leftId = sc.nextInt();
            int rightId = sc.nextInt();
            TreeNode treeNode = new TreeNode(nodeId, nodeValue, leftId, rightId);
            map.put(nodeId, treeNode);
        }
        // 构造树
        for(Integer key : map.keySet()){
            TreeNode treeNode = map.get(key);
            if(treeNode.leftId != -1){
                treeNode.left = map.get(treeNode.leftId);
            }
            if(treeNode.rightId != -1){
                treeNode.right = map.get(treeNode.rightId);
            }
        }
        for(Integer key : map.keySet()){
            TreeNode treeNode = map.get(key);
            dfs(treeNode,0);
        }
        System.out.println(result);
    }
    public static void dfs(TreeNode node, long value){
        if(node == null){
            return;
        }
        value = value ^ node.value;
        result = value > result ? value : result;
        dfs(node.left, value);
        dfs(node.right, value);
    }

    /**
     * ————————————————————————————————————————————————————————
     */
    public static long max = 0;
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] childs = new int[n+1][3];
        long[] values = new long[n+1];
        for(int i=0;i<n;i++){
            int key = sc.nextInt();
            values[key] = sc.nextLong();
            childs[key][0] = sc.nextInt();
            childs[key][1] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            dfs(i, values[i], childs, values);
        }
        System.out.println(max);
    }
    public static void dfs(int i, long sum, int[][] childs, long[] values){
        if(childs[i][0] == -1 && childs[i][1] == -1){
            max = Math.max(max, sum);
            return;
        }
        if(childs[i][0] != -1){
            long temp = values[childs[i][0]];
            max = Math.max(max, temp ^ sum);
            dfs(childs[i][0], temp ^ sum, childs, values);
        }
        if(childs[i][1] != -1){
            long temp = values[childs[i][1]];
            max = Math.max(max, temp ^ sum);
            dfs(childs[i][1], temp ^ sum, childs, values);
        }
    }
}
//5
//1 1 2 3
//2 4 -1 -1
//3 2 -1 4
//4 5 -1 5
//5 3 -1 -1
