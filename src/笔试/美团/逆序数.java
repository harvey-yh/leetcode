package 笔试.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 逆序数 {
    //逆序数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<=n/4;i++){
            if(helper(i, 4*i)){
                count++;
                res.add(new int[]{i, i*4});
            }
        }
        System.out.println(count);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i)[0]+" "+res.get(i)[1]);
        }
    }
    public static boolean helper(int a, int b){
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        int x = 0;
        while(s2.charAt(x) == '0'){
            x++;
        }
        s2 = s2.substring(x);
        if(s1.length() != s2.length()){
            return false;
        }
        int i=0, j=s1.length()-1;
        while(i < s1.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
