package 笔试.字节;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 多米诺骨牌 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int n = Integer.valueOf(s[0]);
        int[][] poke = new int[n][2];
        for(int i=0;i<n;i++){
            String[] str = sc.nextLine().trim().split(" ");
            poke[i][0] = Integer.valueOf(str[0]);
            poke[i][1] = Integer.valueOf(str[1]);
        }
        Arrays.sort(poke, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        long max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(poke[i][0] < poke[j][0] && poke[i][1] < poke[j][1]){
                    dp[j] = Math.max(dp[j], dp[i]+1);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        System.out.println(max);
    }
}
