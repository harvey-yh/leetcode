package 笔试.字节;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 交替和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] up = new int[n];
        int[] down = new int[n];
        int[] dp = new int[n];
        up[0] = a[0];
        down[0] = a[0];
        dp[0] = Math.max(up[0], down[0]);
        if(n > 1){
            up[1] = Math.max(up[0] - a[1], a[1]);
            down[1] = a[0] -a[1];
            dp[1] = Math.max(up[1], down[1]);
        }
        int max = Integer.MIN_VALUE;
        if(n > 2){
            for(int i=2;i<n;i++){
                up[i] = Math.max(up[i-2] - a[i-1], 0)+ a[i];
                down[i] = down[i-2] + a[i-1] - a[i];
                dp[i] = Math.max(up[i], down[i]);
            }
        }
        for(int i=0;i<n;i++){
            max = Math.max(max ,dp[i]);
        }
        System.out.println(max);
    }
}
