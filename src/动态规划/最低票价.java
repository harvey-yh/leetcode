package 动态规划;

/**
 * @author Harvey
 * @date 2020/5/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 最低票价 {
    public int mincostTickets(int[] days, int[] costs) {
        // 将从新年到某一天的花过的所有钱数全部记录起来。
        int[] dp = new int[366];
        //  days的下标，确保遍历365天时，以便于知道下次旅游的日期。
        int index = 0;
        // 因为是第一天，所以过去的总花费为0
        dp[0] = 0;
        // 模拟新年的第一天跑到旅行的最后一天。
        for(int i=1;i<=365;i++){
            if(index == days.length){
                break;
            }
            // 判断今天是否属于旅行日
            if(days[index] != i){
                // 如果这一天不旅行那么直接把上一天的过去总花费拿过来直接使用。
                dp[i] = dp[i-1];
                continue;
            }
            // 如果一月前，买了月票，会不会更便宜？
            // 如果一周前，买了周票，会不会更便宜？
            // 如果都不会的话，那我暂时先买日票试试呗。
            dp[i] = Math.min(dp[Math.max(0,i-1)]+costs[0],
                    Math.min(dp[Math.max(0,i-7)]+costs[1],
                            dp[Math.max(0,i-30)]+costs[2]));
            // 开始等待下一个待旅行的日子到来。
            index++;
        }
        return dp[days[days.length-1]];
    }
}
