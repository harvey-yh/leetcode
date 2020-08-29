package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 分解质因数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        helper(n);

    }
    public static void helper(int n){
        boolean flag = false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                flag = true;
                System.out.print(i+"*");
                helper(n / i);
                break;
            }
        }
        if(!flag){
            System.out.print(n);
        }
    }
}
