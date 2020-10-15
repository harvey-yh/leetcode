package 笔试.贝壳.第二次;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 重建字符串 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        for(int i=n/2;i>=1;i--){
            if(str.substring(i).startsWith(str.substring(0, i))){
                System.out.println(n-i+1 > n ? n : n-i+1);
                break;
            }
        }
    }
}
