package 笔试.腾讯;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 数字之和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            long n = sc.nextLong();
            long max = 0;
            for(long i=0;i <= n/2;i++){
                max = Math.max(max,  s(i)+s(n-i));
            }
            System.out.println(max);
            t--;
        }
    }
    public static long s(long num){
        long sum = 0;
        while(num != 0){
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
