package 笔试.京东;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 回文素数 {
    /**
     * 现有一个正整数，希望去掉这个数中某一个数字之后可以得到一个回文素数。
     *
     * 回文素数是指一个素数同时还是一个回文数（回文数即从左到右和从右到左均一样的数，例如12321）。【注意：一位数也被认为是回文数】
     *
     * 输入两个正整数N和M，满足N<M，请编写一个程序统计N和M之间存在多少个满足上述要求的数？
     * 110 120
     * 10
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int res = 0;
        for(int i=m;i<=n;i++){
            res += helper(i);
        }
        System.out.println(res);
    }

    public static int helper(int x){
        int count = 0;
        String str = String.valueOf(x);
        HashSet<String> list = new HashSet<>();

        int i = str.length()-1, j=str.length()-1;
        while(i>=0){
            if(i == str.length()-1){
                if(!"".equals(str.substring(0,i))){
                    list.add(str.substring(0,i));
                }
            }else if(i == 0 && i+1 < str.length() && str.charAt(i+1) == '0'){
                int t = 2;
                while(i+t < str.length() && str.charAt(i+t) == '0'){
                    t++;
                }
                if(i+t < str.length()){
                    if(!"".equals(str.substring(i+t,j))){
                        list.add(str.substring(i+t,j));
                    }

                }
            }else{
                if(!"".equals(str.substring(0,i)+str.substring(i+1,j+1))){
                    list.add(str.substring(0,i)+str.substring(i+1,j+1));
                }
            }
            i--;
        }
        for(String s : list){
            if(isPrime(Integer.valueOf(s)) && isHiuwen(s)){
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int x){
        if(x == 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isHiuwen(String str){
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}
