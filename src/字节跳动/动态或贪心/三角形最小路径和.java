package 字节跳动.动态或贪心;

import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        List<Integer> last = triangle.get(size - 1);
        for (int i = 0; i < size; i++) {
            dp[i] = last.get(i);
        }
        for (int i = size-2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < i+1; j++) {
                dp[j] = list.get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
