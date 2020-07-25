package 高频面试系列;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/7/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 高效实现素数 {
    /**
     * 如果我们知道 2 是⼀个素数，那么 2 × 2 = 4, 2 × 3 = 6, 2 × 4 = 8...都不可能是素数了。
     * 如果我们发现 3 也是⼀个素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12... 也都不可能是素数了。
     * @param n
     * @return
     */
    static int countPrimes(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i=2;i*i<n;i++){
            if(!dp[i]){
                for(int j=i*i;j<n;j += i){
                    dp[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(!dp[i]){
                count++;
                System.out.println(i);
            }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(countPrimes(100));
    }
}
