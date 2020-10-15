package 笔试.百度;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/9/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 牧场 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();//奶牛数量
            int m = sc.nextInt();//特性的数量
            int[] nums = new int[n+1];
            for(int i=0;i<m;i++){
                int k = sc.nextInt();
                for(int j=0;j<k;j++){
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    for(int z = start;z <= end;z++){
                        nums[z] += 1;
                    }
                }
            }
            int count = 0, end = 0;
            for(int i=1;i<=n;i++){
                if(nums[i] == m){
                    count++;
                    end = i;
                }
            }
            System.out.println(count);
            for(int i=1;i<end;i++){
                if(nums[i] == m){
                    System.out.print(i+" ");
                }
            }
            System.out.println(end);
        }
    }
}
