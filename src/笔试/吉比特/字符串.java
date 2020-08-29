package 笔试.吉比特;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        String a = sc.next().toLowerCase();
        String b = sc.next().toLowerCase();
        System.out.println(Math.max(helper(str,a,b), helper(str,b,a)));
    }
    public static int helper(String str, String a, String b){
        int l=-1, r=-1;
        for(int i=0;i< str.length();i++){
            if(str.charAt(i) == a.charAt(0)){
                l = i;
                break;
            }
        }
        for(int i=str.length()-1;i>= 0;i--){
            if(str.charAt(i) == b.charAt(0)){
                r = i;
                break;
            }
        }
        if(l == -1 || r == -1){
            return -1;
        }else{
            return Math.abs(r-l);
        }
    }
}
