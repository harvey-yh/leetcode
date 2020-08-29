package 笔试.腾讯;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 刷板子 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        System.out.println(min + " " + max);
        int res = min, level = min+1, index = 0;
        while(level <= max){
            if(a[index] < level){
                index++;
                continue;
            }
            int j = index;
            while(j < n-1){
                if(a[j] < level){
                    j++;
                    continue;
                }
                if(a[j+1] < level){
                    res++;
                    j+=2;
                }else{
                    j++;
                }
            }
            if(j == n-1 && a[j] >= level) {
                res++;
            }
            level++;
        }
        System.out.println(res > n ? n : res);
    }
}
