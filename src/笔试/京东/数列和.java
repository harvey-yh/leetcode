package 笔试.京东;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 数列和 {
    /**
     * 求以下数列的和：
     *
     * f(n)=1/5-1/10+1/15-1/20+1/25-.......+1/(5*(2*n-1))-1/(5*2*n)
     *
     * 输入描述：单组输入。每组数据一个输入，每个输入一行，输入n。(n<=100)
     *
     * 输出描述：输出数列前n项的和，结果四舍五入保留四位小数。
     *
     * 样例输入：1
     *
     * 样例输出：0.1000
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String[] s;
        double sum;
        while (sc.hasNextLine()){
            s = sc.nextLine().trim().split(" ");
            n = Integer.valueOf(s[0]);
            sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += 1.0 / (5*(2*n-1)) - 1.0 / (5*2*n);
            }
            System.out.println(String.format("%.4f",sum));
        }
    }
}
