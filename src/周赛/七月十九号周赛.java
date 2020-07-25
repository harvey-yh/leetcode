package 周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/7/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 七月十九号周赛 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int noBottles = numBottles;
        while (noBottles >= numExchange) {
            int change = noBottles / numExchange;
            int rest = noBottles >= numExchange ? noBottles % numExchange : 0;
            res += change;
            noBottles = change + rest;
        }
        return res;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].c = labels.charAt(i) - 'a';
        }
        for (int[] e : edges) {
            Node a = nodes[e[0]];
            Node b = nodes[e[1]];
            a.adj.add(b);
            b.adj.add(a);
        }
        dfs(nodes[0], null);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nodes[i].dp[nodes[i].c];
        }
        return ans;
    }

    public void dfs(Node root, Node p) {
        root.dp[root.c]++;
        for (Node node : root.adj) {
            if (node == p) {
                continue;
            }
            dfs(node, root);
            for (int i = 0; i <= 'z' - 'a'; i++) {
                root.dp[i] += node.dp[i];
            }
        }
    }

    public static void main(String[] args){
//        System.out.println(numWaterBottles(15, 4));
//        System.out.println(countSubTrees(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}, "abaedcd"));

    }

}
class Node{
    List<Node> adj = new ArrayList<>();
    int c;
    int[] dp = new int['z' - 'a' + 1];
}
