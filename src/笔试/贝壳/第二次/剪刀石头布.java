package 笔试.贝壳.第二次;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 剪刀石头布 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String[] nm = new String[2];
            String[] nn = new String[2];
            nm[0] = sc.next();
            nm[1] = sc.next();
            nn[0] = sc.next();
            nn[1] = sc.next();
            int prob_l = helper(nm, nn, 0);
            int prob_r = helper(nm, nn, 1);
            if(prob_l == prob_r){
                System.out.println("same");
            }else if(prob_l > prob_r){
                System.out.println("left");
            }else{
                System.out.println("right");
            }
        }
    }
    public static int helper(String[] nm, String[] nn, int x){
        int count = 0;
        if(nm[x].equals("S")){
            for(int i=0;i<2;i++){
                if(nn[i].equals("J")){
                    count++;
                }else{
                    count--;
                }
            }
        }else if(nm[x].equals("J")){
            for(int i=0;i<2;i++){
                if(nn[i].equals("B")){
                    count++;
                }else{
                    count--;
                }
            }
        }else if(nm[x].equals("B")){
            for(int i=0;i<2;i++){
                if(nn[i].equals("S")){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return count;
    }
}
