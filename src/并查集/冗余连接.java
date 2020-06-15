package 并查集;

/**
 * @author Harvey
 * @date 2020/6/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 冗余连接 {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0 || edges[0].length == 0){
            return new int[0];
        }
        int length = edges.length;
        parent = new int[length+1];
        for(int i=0;i<=length;i++){
            parent[i] = i;
        }

        for(int i=0;i<length;i++){
            // 找到节点0的根节点
            int set1 = findParent(edges[i][0]);
            // 找到节点1的根节点
            int set2 = findParent(edges[i][1]);
            // 根节点相同说明两个节点本身就在一个集合里，说明这条边会造成环的形成，那么这条边就是满足要求的那条边
            // 如果不在一个集合中，那么节点0的根节点设置成节点1的根节点，使得两个节点在一个集合中
            if(set1==set2){
                return edges[i];
            }else {
                parent[set1] = set2;
            }
        }
        return new int[]{0,0};
    }

    /**
     * 找到集合的根节点
     * @param num
     * @return
     */
    private int findParent(int num) {
        while (num!=parent[num]){
            num = parent[num];
        }
        return num;
    }
}
