package 笔试.阿里;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 买房子 {
    /**
     * 小明有n个朋友，每个朋友有一定数量的钱去买房子，每个房子有舒适度和价格。
     * 要求:1、一个人最多买一个房子。2、每个房子只能被一个人买。3、钱数必须大于房子价格。
     * 问：如何买房子，使得舒适度之和最大。
     * 2 5
     * 2 1
     * 4 1
     * 4 3
     * 3 10
     * 3 1
     * 5 3
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        int[][] para = new int[m][2];
        for(int i=0;i<n;i++){
            coins[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            para[i][0] = sc.nextInt();
            para[i][1] = sc.nextInt();
        }
        Arrays.sort(para, (a, b)->a[0]==b[0] ? a[1]- b[1] : b[0]-a[0]);
        Arrays.sort(coins);
        long sum = 0L;
        boolean[] buy = new boolean[n];
        int i=0,j;
        for (; i < m;i++) {
            for (j=0;j < n;j++) {
                if (buy[j]) {
                    continue;
                }
                if (coins[j] >= para[i][1]) {
                    buy[j] = true;
                    sum += para[i][0];
                    break;
                }
            }
        }
        System.out.print(sum);
    }

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        Integer[] coins = new Integer[n];
//        Integer[][] para = new Integer[m][2];
//        for(int i=0;i<n;i++){
//        coins[i] = sc.nextInt();
//        }
//        for(int i=0;i<m;i++){
//        para[i][0] = sc.nextInt();
//        para[i][1] = sc.nextInt();
//        }
//        // u1:4   u2:3
//        // h1:2  3
//        // h2:2  2
//        /**
//        * 2  1
//        *
//        * 4  1
//        * 4  3
//        * 3  10
//        * 3  10
//        * 2  10
//        */
//        //        Arrays.sort(para, (a,b)->a[1].equals(b[1]) ? b[0]- a[0] : b[1]-a[1]);
//        Arrays.sort(para, (a,b)->a[0].equals(b[0]) ? a[1]- b[1] : b[0]-a[0]);
//        Arrays.sort(coins);
//        int i=0,j=0;
//        long sum = 0;
//        boolean[] used = new boolean[n];
//        int x = 0;
//        while(x < n && j < m){
//        if(coins[i%n] >= para[j][1] && !used[i%n]){
//            sum += para[j][0];
//            j++;
//            i++;
//            x++;
//            used[i%n] = true;
//        }else if(coins[i%n] < para[j][1] && !used[i%n]){
//            if(i < n){
//                j++;
//            }else{
//                i++;
//            }
//        }else{
//            i++;
//        }
//        }
//        System.out.print(sum);
}
