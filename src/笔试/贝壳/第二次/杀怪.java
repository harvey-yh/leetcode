package 笔试.贝壳.第二次;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 杀怪 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a_l = new int[n+1];
        int[] a_r = new int[n+1];
        int[] b_l = new int[n+1];
        int[] b_r = new int[n+1];
        for(int i=n;i>0;i--){
            a_l[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            a_r[i] = sc.nextInt();
        }
        for(int i=n;i>0;i--){
            b_l[i] = sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            b_r[i] = sc.nextInt();
        }
        int i=-1,j=1;
        long blood = 0;
        long min = 0;
        while(i >= -n && j <= n){
            if(a_l[-i] < a_r[j]){
                blood -= a_l[-i];
                if(blood < 0){
                    min = Math.max(min, -blood);
                }
                blood += b_l[-i];
                i--;
            }else if(a_l[-i] > a_r[j]){
                blood -= a_r[j];
                if(blood < 0){
                    min = Math.max(min, -blood);
                }
                blood += b_r[j];
                j++;
            }else{
                if(b_l[-i] >= b_r[j]){
                    blood -= a_l[-i];
                    if(blood < 0){
                        min = Math.max(min, -blood+1);
                    }
                    blood += b_l[-i];
                    i--;
                }else{
                    blood -= a_r[j];
                    if(blood < 0){
                        min = Math.max(min, -blood+1);
                    }
                    blood += b_r[j];
                    j++;
                }
            }
        }
        if(i < -n){
            while(j <= n){
                blood -= a_r[j];
                if(blood < 0){
                    min = Math.max(min, -blood+1);
                }
                blood += b_r[j];
                j++;
            }
        }else if(j > n){
            while(i >= -n){
                blood -= a_l[-i];
                if(blood < 0){
                    min = Math.max(min, -blood+1);
                }
                blood += b_l[-i];
                i--;
            }
        }
        System.out.println(min);
    }
}
