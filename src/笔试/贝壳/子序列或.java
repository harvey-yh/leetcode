package 笔试.贝壳;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 子序列或 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int[] res = new int[2];
        for(int i=0;i<n;i++){
            int x = a[i];
            for(int j=i;j<n;j++){
                x = x | a[j];
                if(max < x){
                    max = Math.max(max, x);
                    res[0] = i;
                    res[1] = j;
                }else if(max == x){
                    if(res[1] - res[0] > j - i){
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        System.out.println(res[1] - res[0] + 1);
    }
}
