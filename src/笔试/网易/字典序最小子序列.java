package 笔试.网易;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 字典序最小子序列 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int n = Integer.valueOf(str[0]);
        int m = Integer.valueOf(str[1]);
        int[] T = new int[m+1];
        boolean[] used = new boolean[n+1];
        for(int i=1;i<=m;i++){
            int x = sc.nextInt();
            T[i] = x;
            used[x] = true;
        }
        int[] res = new int[n+1];
        int j = 1, i = 1, t = 1, x = 0;
        while(j <= n){
            if(x < m){
                while(i <= m && t < T[i] && used[t]){
                    t++;
                }
                if(t < T[i]){
                    res[j] = t;
                    used[t] = true;
                }else{
                    res[j] = T[i];
                    i++;
                    x++;
                }
            }else{
                while(t<n && used[t]){
                    t++;
                }
                res[j] = t;
                used[t] = true;
            }
            if(j < n){
                System.out.print(res[j]+" ");
            }else{
                System.out.print(res[j]);
            }
            j++;
        }
    }
}
