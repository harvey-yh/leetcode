package 笔试.网易.第二次;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 樱桃树 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1;i<=m;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            String s = sc.next();
            int y = sc.nextInt();
            map.get(x).add(y);
        }
        int res = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            List<Integer> value = entry.getValue();
            if(value.size() == 2){
                if(map.get(value.get(0)).size() == 0 && map.get(value.get(1)).size() == 0){
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
