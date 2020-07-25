package 并查集;

/**
 * @author Harvey
 * @date 2020/7/25
 * @slogan Drive business with technology, make business generate value.
 */
public class UnionFind {
    /**
     * 连通分量个数
     */
    private int count;
    /**
     * 存储⼀棵树
      */
    private int[] parent;
    /**
     * 记录树的“重量”
     */
    private int[] size;
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        // 最初每棵树只有⼀个节点
        // 重量应该初始化 1
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        // ⼩树接到⼤树下⾯，较平衡，按秩合并
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    public int find(int x){
        while(parent[x] != x){
            // 路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count() {
        return count;
    }
}
