package 笔试.网易.第二次;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 男女约会 {
    /**
     * 0%ac
     */
    static int max;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().trim().split(" ");
        String[] str2 = sc.nextLine().trim().split(" ");
        int[] boys = new int[str1.length];
        int[] girls = new int[str2.length];
        for(int i=0;i<boys.length;i++){
            boys[i] = Integer.valueOf(str1[i]);
        }
        for(int i=0;i<girls.length;i++){
            girls[i] = Integer.valueOf(str2[i]);
        }
        int n = sc.nextInt();
        int[][] match = new int[n][2];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            match[i][0] = sc.nextInt();
            match[i][1] = sc.nextInt();
            if(!map.containsKey(match[i][0])){
                map.put(match[i][0], new ArrayList<>());
                map.get(match[i][0]).add(match[i][1]);
            }
        }
        int res = 0;
        for(Integer g : map.get(boys[0])){
            List<Integer> list = new ArrayList<>();
            list.add(g);
            max = 1;
            helper(new HashMap<>(map), boys, 1, list);
            res = Math.max(res, max);
        }
        System.out.println(res);
    }
    public static void helper(HashMap<Integer, List<Integer>> map, int[] boys, int i, List<Integer> tmp){
        if(i == boys.length){
            return ;
        }
        for(Integer g : map.get(boys[i])){
            if(!tmp.contains(g)){
                tmp.add(g);
                max++;
                helper(map, boys, i+1, tmp);
                tmp.remove(g);
            }else{
                helper(map, boys, i+1, tmp);
            }
        }

    }
}
