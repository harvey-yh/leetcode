package 笔试.贝壳.第二次;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 涂颜料 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(); //栅栏总数
            int m = sc.nextInt(); //颜料总数
            int k = sc.nextInt(); //每种颜料后不能紧跟的颜料种类数
            HashSet<Integer>[] color = new HashSet[m+1];
            for(int i=1;i<=m;i++){
                color[i] = new HashSet<>();
                for(int j=1;j<=k;j++){
                    color[i].add(sc.nextInt());
                }
            }
            int[][] dp = new int[n+1][m+1];
            for(int i=1;i<=m;i++){
                dp[1][i] = 1;
            }
            for(int i=2;i<=n;i++){
                for(int j=1;j<=m;j++){
                    for(int z=1;z<=m;z++){
                        if(!color[j].contains(z)){
                            dp[i][z] += dp[i-1][j];
                            dp[i][z] %= 1000000007;
                        }
                    }
                }
            }
            long count = 0;
            for(int i=1;i<=m;i++){
                count += dp[n][i];
                count %= 1000000007;
            }
            System.out.println(count);
        }
    }
}
