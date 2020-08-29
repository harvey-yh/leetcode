package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 礼物价值最大化 {
    static int max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().trim().split(",");
        int m = Integer.valueOf(str[0]);
        int n = Integer.valueOf(str[1]);
        int[][] value = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                value[i][j] = sc.nextInt();
            }
        }
        dfs(value, m, n, 0, 0, 0);
        System.out.println(max);

    }
    public static void dfs(int[][] value, int m, int n, int i, int j, int tmp){
        if(i == m-1 && j == n-1){
            tmp += value[i][j];
            max = Math.max(tmp, max);
            return ;
        }
        if(i < m-1){
            dfs(value, m, n, i+1, j, tmp+value[i][j]);
        }
        if(j < n-1){
            dfs(value, m, n, i, j+1, tmp+value[i][j]);
        }
    }
}
