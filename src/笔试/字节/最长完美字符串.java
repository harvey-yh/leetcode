package 笔试.字节;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 最长完美字符串 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] ch = sc.next().toCharArray();
        int[] a = new int[26];
        for(int i = 0;i<n;i++){
            a[ch[i]-'a'] = 1;
        }
        int max = 0;
        for(int i = 0;i<26;i++){
            if(a[i] != 0){
                int l=0, r=0, t=0;
                while(r < n){
                    if(t <= m){
                        if(ch[r] != 'a'+i){
                            t++;
                        }
                        r++;
                    }else{
                        max = Math.max(max, r - l - 1);
                        while(t > m){
                            if(ch[l] == 'a'+i){
                                l++;
                            }else{
                                t--;
                                l++;
                            }
                        }
                    }
                }
                max = Math.max(max, r - l);
            }
        }
        System.out.println(max);
    }
}
