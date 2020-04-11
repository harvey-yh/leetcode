package 贪心算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 分发糖果 {
    public static int candy(int[] ratings) {
        int n=ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1]+1;
            }
        }
        int sum = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            sum += candy[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int[] ratings = new int[]{1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
    }
}
