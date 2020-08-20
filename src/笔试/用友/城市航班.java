package 笔试.用友;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Harvey
 * @date 2020/8/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 城市航班 {
    /**
     * 现在给定所有的城市和航班，以及出发城市src，你的任务是找到从 scr城市出发到其他所有城市最便宜的机票价格列表。
     * 假设两个城市之间机票价格不会超过Integer.MAX_V
     *
     * 3,[[0,1,100],[1,2,100],[0,2,500]],0
     */
    static HashMap<Integer, ArrayList<int[]>> map;
    static int[] res;
    public static int[] findAllCheapestPrice(int n, int[][] flights, int src) {
        map = new HashMap<>();
        for(int i=0;i<flights.length;i++){
            if(!map.containsKey(flights[i][0])){
                map.put(flights[i][0], new ArrayList<>());
            }
            map.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src] = 0;
        bfs(src);

        for(int i=0;i<res.length;i++){
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        res[src] = 0;
        Arrays.stream(res).forEach(System.out::print);
        return res;
    }

    public static void bfs(int src){
        for(int[] target: map.get(src)){
            if(res[src] + target[1] < res[target[0]]){
                res[target[0]] = res[src] + target[1];
            }
            if(map.containsKey(target[0])){
                bfs(target[0]);
            }
        }
    }
}
