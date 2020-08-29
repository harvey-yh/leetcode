package 笔试.广联达;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 跳舞机 {
    public static void main(String[] args){
        //WASDWWSAD
        //WASSWWAAD
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int score = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) == str2.charAt(i)){
                score += 20;
            }else{
                if(score > 0){
                    score -= 10;
                }else{
                    score = 0;
                }
            }
        }
        System.out.println(score);
    }
}
