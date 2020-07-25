package 深度或广度优先遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/7/16
 * @slogan Drive business with technology, make business generate value.
 *
 * 广优的话，占内存多，能找到最优解，必须遍历所有分枝.
 * 深优的话，占内存少，能找到最优解（一定条件下），但能很快找到接近解（优点），可能不必遍历所有分枝（也就是速度快）, 深优的一个应用就是连连看游戏.
 *
 * 对于这道题来说，我们只需要找到一个不符合，就可以直接返回false，不需要再往下找，所以深度优先遍历就比广度优先遍历要快。
 */
public class 判断二分图 {
    private boolean[] visited;
    private int[] colors;
    /**
     * 深度优先遍历
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!dfs(graph, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int node : graph[v]) {
            if (!visited[node]) {
                if(!dfs(graph, node, color == 0 ? 1 : 0)){
                    return false;
                }
            } else {
                if (colors[node] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 广度优先遍历
     * @param graph
     * @return
     */
    public boolean isBipartite1(int[][] graph) {
        if(graph == null || graph.length == 0){
            return false;
        }
        int n = graph.length;
        //0代表未访问，1与-1代表两种不同色
        int[] color = new int[n];
        for(int k = 0; k < n; k++){
            if(color[k] != 0) {
                continue;
            }
            //广度优先队列
            List<Integer> v = new ArrayList<>();
            v.add(k);
            color[k] = 1;
            while(!v.isEmpty()){
                int p = v.remove(0);
                for(int i = 0; i < graph[p].length; i++){
                    //未染色的入队，已染色作比较
                    if(color[graph[p][i]] != 0 && color[p] == color[graph[p][i]]) {
                        return false;
                    }else if(color[graph[p][i]] == 0){
                        color[graph[p][i]] = -color[p];
                        v.add(graph[p][i]);
                    }
                }
            }
        }
        return true;
    }
}
