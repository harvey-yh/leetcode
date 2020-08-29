package 笔试.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 删除节点 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(i == k-1){
                continue;
            }
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().substring(0,sb.toString().length()-1));
    }
}
