package 周赛;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Harvey
 * @date 2020/6/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 六月七日周赛 {
    /**
     * 5428. 重新排列数组
     * @param nums
     * @param n
     * @return
     */
    public static int[] shuffle(int[] nums, int n) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length];
        int i=0;
        while(i < 2*n){
            res[i] = nums[i];
            res[i+1] = nums[i+n];
            i+=2;
        }
        return res;
    }
    static int midNum = 0;
    /**
     * 5429. 数组中的 k 个最强值
     * @param arr
     * @param k
     * @return
     */
    public static int[] getStrongest(int[] arr, int k) {
        Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr);
        midNum = arr[(arr.length-1)/2];
        Arrays.sort(tmp, (a, b) -> {
            int ans = Math.abs(a - midNum) - Math.abs(b - midNum);
            if(ans == 0){
                ans = a - b;
            }
            return -ans;
        });
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = tmp[i];
        }
        return res;
    }

    /**
     * 5431. 给房子涂色 III
     * @param houses
     * @param cost
     * @param m
     * @param n
     * @param target
     * @return
     */
    int inf = (int)1e9;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(dp[i][j], inf);
            }
        }
        dp[0][0][0] = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 0; k <= target; k++){
                    if(houses[i - 1] != 0 && houses[i - 1] != j){
                        continue;
                    }
                    int c = cost[i - 1][j - 1];
                    if(houses[i - 1] != 0){
                        c = 0;
                    }
                    //same
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + c);
                    for(int t = 0; t <= n && k > 0; t++){
                        if(t == j){
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][t][k - 1] + c);
                    }
                }
            }
        }

        int ans = inf;
        for(int i = 1; i <= n; i++){
            ans = Math.min(ans, dp[m][i][target]);
        }

        //System.out.println(Arrays.deepToString(dp));
        if(ans >= inf){
            return -1;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(getStrongest(new int[]{-7,22,17,3},2));
    }
}
