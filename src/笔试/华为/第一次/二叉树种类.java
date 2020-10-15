package 笔试.华为.第一次;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Harvey
 * @date 2020/8/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 二叉树种类 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = sc.nextInt();
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxHigh = 0;
        for(int e : height){
            if(maxHigh < e){
                maxHigh = e;
            }
            if(!treeMap.containsKey(e)){
                treeMap.put(e, 1);
            }else{
                int num = treeMap.get(e);
                treeMap.put(e,num+1);
            }
        }
        int numTreeType = 1;
        for(int i=maxHigh;i > 0;i--){
            int hou = treeMap.get(i);
            int qian = treeMap.get(i-1);
            int center = zuhe(hou, qian*2);
            numTreeType *= center;
        }
        System.out.println(numTreeType);

    }
    public static int zuhe(int m, int n){
        if(m == n){
            return 1;
        }else if(n-m == 1 || m == 1){
            return n;
        }
        int fenmu = 1;
        int fenzi1 = 1;
        int fenzi2 = 1;
        for(int i=2;i<=m;i++){
            fenzi1 *= i;
        }
        for(int i=2;i<=n-m;i++){
            fenzi2 *= i;
        }
        for(int i=m+1;i<=n;i++){
            fenmu *= i;
        }
        return fenmu / (fenzi1 * fenzi2);
    }
}
