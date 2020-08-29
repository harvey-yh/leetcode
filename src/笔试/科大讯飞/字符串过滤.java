package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串过滤 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int i=0, count = 0;
        while(i < str.length() && str.charAt(i) == '_'){
            i++;
        }
        int j=str.length()-1;
        while(j >= 0 && str.charAt(j) == '_'){
            j--;
        }
        for(int k=i;k<=j;k++){
            char c = str.charAt(k);
            if(c != '_'){
                System.out.print(c);
                count = 0;
            }else if(count >= 1){
                continue;
            }else{
                count++;
                System.out.print("_");
            }
        }
    }
}
