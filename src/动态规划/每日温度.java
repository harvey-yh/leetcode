package 动态规划;

/**
 * @author Harvey
 * @date 2020/7/16
 * @slogan Drive business with technology, make business generate value.
 */
public class 每日温度 {
    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] dp = new int[T.length];
        dp[T.length-1] = 0;
        for(int i = T.length-2;i>=0;i--){
            for(int j = i+1;j<T.length;j+=dp[j]){
                if(T[i] < T[j]){
                    dp[i] = j-i;
                    break;
                }
                if(dp[j] == 0){
                    dp[i] = 0;
                    break;
                }
            }
        }
        return dp;
    }
}
