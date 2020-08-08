package 笔试.网易;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 两个人分东西 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int t = Integer.valueOf(str[0]);
        while(t>0) {
            String[] s = sc.nextLine().trim().split(" ");
            int n = Integer.valueOf(s[0]);
            int[] val = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                val[i] = sc.nextInt();
                sum += val[i];
            }
            boolean[] dp = new boolean[1500005];
            dp[0] = true;
            for(int i=0;i<n;i++){
                for(int j=sum;j>=val[i];j--){
                    dp[j] = dp[j] | dp[j-val[i]];
                }
            }
            int res = sum;
            for(int i=sum;i >= 0;i--){
                if(i%2 != 0){
                    continue;
                }
                if(dp[i] && dp[i/2]){
                    res = sum - i;
                    break;
                }
            }
            System.out.println(res);
            t--;
        }
    }
}
