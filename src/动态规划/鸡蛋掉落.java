package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/11
 * @slogan Drive business with technology, make business generate value.
 */
public class 鸡蛋掉落 {
    /**
     * k个蛋，N层楼，临界点F。
     * 动态规划掌握两个关键：状态和选择
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N){
        /**
         * # 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
         * # 这个状态下，最坏情况下最多能确切测试⼀栋 n 层的楼
         * # ⽐如说 dp[1][7] = 7 表⽰：
         * # 现在有 1 个鸡蛋，允许你扔 7 次;
         * # 这个状态下最多给你 7 层楼，
         * # 使得你可以确定楼层 F 使得鸡蛋恰好摔不碎
         * # （⼀层⼀层线性探查嘛）
         */
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int m = 0;
        for (m=1; dp[K][m] < N; m++) {
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    /**
     * 鸡蛋掉落，鹰蛋（Leetcode 887）：（经典dp）
     * 有 K 个鸡蛋，有 N 层楼，用最少的操作次数 F 检查出鸡蛋的质量。
     *
     * 思路：
     * 本题应该逆向思维，若你有 K 个鸡蛋，你最多操作 F 次，求 N 最大值。
     *
     * dp[k][f] = dp[k][f-1] + dp[k-1][f-1] + 1;
     * 解释：
     * 0.dp[k][f]：如果你还剩 k 个蛋，且只能操作 f 次了，所能确定的楼层。
     * 1.dp[k][f-1]：蛋没碎，因此该部分决定了所操作楼层的上面所能容纳的楼层最大值
     * 2.dp[k-1][f-1]：蛋碎了，因此该部分决定了所操作楼层的下面所能容纳的楼层最大值
     * 又因为第 f 次操作结果只和第 f-1 次操作结果相关，因此可以只用一维数组。
     *
     * 时复：O(K*根号(N))
     */
    public int superEggDrop1(int K, int N) {
        int[] dp = new int[K + 1];
        // 操作的次数
        int ans = 0;
        while (dp[K] < N){
            for (int i = K; i > 0; i--) {
                // 从后往前计算
                dp[i] = dp[i] + dp[i-1] + 1;
            }
            ans++;
        }
        return ans;
    }
}
