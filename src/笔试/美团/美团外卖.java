package 笔试.美团;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/8/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 美团外卖 {
    /**
     * 小团是美团外卖的区域配送负责人，众所周知，外卖小哥一般都会同时配送若干单，小团在接单时希望把同一个小区的单子放在一起，然后由一名骑手统一配送。但是由于订单是叠在一起的，所以，他归类订单时只能知道新订单和已有的某个订单的小区是相同的，他觉得这样太麻烦了，所以希望你帮他写一个程序解决这个问题。
     * 即给出若干个形如a b的关系，表示a号订单和b号订单是同一个小区的 ，请你把同一个小区的订单按照编号顺序排序，并分行输出，优先输出最小的订单编号较小的小区订单集合。订单的编号是1到n。(可能存在同时出现a b和b a这样的关系,也有可能出现a a这样的关系)
     *
     * @param args
     */
    static int[] parent;
    static int count;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] order = new int[m][2];
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        count = n;
        for(int i=0;i<m;i++){
            order[i][0] = sc.nextInt();
            order[i][1] = sc.nextInt();
            union(order[i][0], order[i][1]);
        }
        System.out.println(count);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            int p =find(parent[i]);
            if(!map.containsKey(p)){
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(i);
        }
        HashMap<Integer, Integer[]> res = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Integer[] a = entry.getValue().toArray(new Integer[0]);
            Arrays.sort(a);
            res.put(entry.getKey(), a);
        }
        List<Map.Entry<Integer,Integer[]>> list = new ArrayList<>(res.entrySet());
        list.sort((o1,o2)->o1.getValue()[0] - o2.getValue()[0]);
        for(Map.Entry<Integer,Integer[]> r : list){
            Integer[] value = r.getValue();
            for(int i=0;i<value.length-1;i++){
                System.out.print(value[i]+" ");
            }
            System.out.print(value[value.length-1]);
            System.out.println();
        }
    }

    public static int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }
    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            parent[py] = px;
            count--;
        }
    }
}
