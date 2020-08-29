package 笔试.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 第k小字串 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                if(!list.contains(str.substring(i, j))){
                    list.add(str.substring(i, j));
                }
            }
        }
        list.sort((o1,o2)->o1.compareTo(o2));
        System.out.println(list.get(k-1));
    }
}
