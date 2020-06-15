package 周赛;

/**
 * @author Harvey
 * @date 2020/6/14
 * @slogan Drive business with technology, make business generate value.
 */
class TreeAncestor {
    int[] parent;
    int n;
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;
    }

    /**
     * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
     *
     * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
     * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
     * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
     * @param node
     * @param k
     * @return
     */
    public int getKthAncestor(int node, int k) {
        if(node >= this.n){
            return -1;
        }
        int nextnode = 0;
        while(k > 0){
            nextnode = parent[node];
            k--;
            if(nextnode == -1){
                return -1;
            }else{
                node = nextnode;
            }
        }
        return nextnode;
    }
    public static void main(String[] args){
        TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1,0,0,0,3});

        System.out.println(treeAncestor.getKthAncestor(1,5));  // 返回 1 ，它是 3 的父节点
        System.out.println(treeAncestor.getKthAncestor(3,2));  // 返回 0 ，它是 5 的祖父节点
        System.out.println(treeAncestor.getKthAncestor(0,1));  // 返回 -1 因为不存在满足要求的祖先节点
        System.out.println(treeAncestor.getKthAncestor(3,1));  // 返回 -1 因为不存在满足要求的祖先节点
        System.out.println(treeAncestor.getKthAncestor(3,5));  // 返回 -1 因为不存在满足要求的祖先节点
//        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
//
//        System.out.println(treeAncestor.getKthAncestor(3, 1));  // 返回 1 ，它是 3 的父节点
//        System.out.println(treeAncestor.getKthAncestor(5, 2));  // 返回 0 ，它是 5 的祖父节点
//        System.out.println(treeAncestor.getKthAncestor(6, 3));  // 返回 -1 因为不存在满足要求的祖先节点
    }
}
