package 笔试.贝壳;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 回文串构造 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next().trim().substring(0,n);
        int i=0, j=n-1;
        int res = 0;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                res++;
            }
            i++;
            j--;
        }
        System.out.println(res);
    }
}
