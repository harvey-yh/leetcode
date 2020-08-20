package 笔试.美团;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 商店 {
    /**
     * 小团正在装饰自己的书桌，他的书桌上从左到右有m个空位需要放上装饰物。商店中每个整数价格的装饰物恰好有一种，且每种装饰物的数量无限多。
     * 小团去商店的时候，想到了一个购买方案，他要让右边的装饰物价格是左边的倍数。用数学语言来说，假设小团的m个装饰物价格为a1,a2...am，
     * 那么对于任意的1≤i≤j≤m，aj是ai的倍数。
     * 小团是一个节约的人，他希望最贵的装饰物不超过n元。现在，请你计算小团有多少种购买的方案？
     * 输入描述
     * 输入包含两个数，n和m（1≤n,m≤1000）
     *
     * 输出描述
     * 输出一个数，结果对998244353取模，表示购买的方案数。
     *
     * 样例输入
     * 4 2
     * 样例输出
     * 8
     * 样例解释
     * [1,1][1,2][1,3][1,4][2,2][2,4][3,3][4,4]共8种
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();


    }
}
