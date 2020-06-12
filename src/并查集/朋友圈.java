package 并查集;

import 设计.MedianFinder;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 朋友圈 {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length){
            return 0;
        }
        int[] root = new int[M.length];
        for(int i=0;i<M.length;i++){
            root[i] = -1;
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                if(i != j && M[i][j] == 1){
                    union(root, i, j);
                }
            }
        }
        int res = 0;
        for(int i=0;i<root.length;i++){
            if(root[i] == -1){
                res++;
            }
        }
        return res;
    }

    public void union(int[] root, int x, int y) {
        int root1 = find(root, x);
        int root2 = find(root, y);
        if (root1 != root2){
            root[root1] = root2;
        }
    }

    public int find(int[] root, int i) {
        if (root[i] == -1){
            return i;
        }
        return find(root, root[i]);
    }


}
