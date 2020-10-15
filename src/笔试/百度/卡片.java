package 笔试.百度;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 卡片 {
    /**
     * 11
     * 5 5 5 5 5 5 5 5 0 5 5
     * 5 5 5 5 5 5 5 5 5 0 0
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        int fivecount = 0;
        int zerocount = 0;
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
            if(nums[i] == 5){
                fivecount++;
            }
            if(nums[i] == 0){
                zerocount++;
            }
        }
        int i;
        for(i=fivecount;i>0;i--){
            if(i % 9 == 0){
                break;
            }
        }
        if(fivecount == 0){
            System.out.println(-1);
        }else{
            for(int j=0;j<i;j++){
                System.out.print(5);
            }
            for(int j=0;j<zerocount;j++){
                System.out.print(0);
            }
        }

    }
}
