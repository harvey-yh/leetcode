package 笔试.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/21
 * @slogan Drive business with technology, make business generate value.
 */
public class A加B问题 {
    /**
     * A+B问题又来了。
     *
     * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，现给定一正整数n，
     * 问有多少对abc和acc能满足abc+acc=n（a≠0）？
     *
     * 输入描述
     * 一个正整数n（100<n<2000）。
     *
     * 输出描述
     * 第一行输出有多少对满足要求的数字。
     *
     * 接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<String[]> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            for(int j=0;j<=9;j++){
                for(int t=0;t<=9;t++){
                    if(i != j && i != t && j != t){
                        int x = i*100+j*10+t;
                        int y = i*100+t*10+t;
                        if(x+y == n){
                            StringBuilder str1 = new StringBuilder();
                            StringBuilder str2 = new StringBuilder();
                            str1.append(i).append(j).append(t);
                            str2.append(i).append(t).append(t);
                            res.add(new String[]{str1.toString(), str2.toString()});
                            count++;
                        }
                    }
                }
            }
        }
        res.sort((o1,o2)->o1[0].compareTo(o2[0]));
        System.out.println(count);
        for(String[] arr : res){
            System.out.println(arr[0] + " " + arr[1]);
        }
    }
}
