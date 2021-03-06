package 并查集;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 朋友圈 {
    private int count;
    private int[] parent;
    public int findCircleNum(int[][] M){
        count = M.length;
        parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i+1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private void union( int x, int y){
        int parent1 = find(x);
        int parent2 = find(y);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
            count--;
        }
    }

    private int find( int p){
        while (p != parent[p]) {
            //路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
