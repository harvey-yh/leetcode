package 并查集;

import 设计.MedianFinder;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 朋友圈 {
    int count;
    int[] parent;
    public int findCircleNum( int[][] M){
        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) {
            return 0;
        }
        count = M.length;
        parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    public void union( int x, int y){
        int parent1 = find(x);
        int parent2 = find(y);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
            count--;
        }
    }

    public int find( int p){
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
