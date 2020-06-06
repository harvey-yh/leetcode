package 贪心算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        // 统计不同字符有多少
        for(char ch : tasks) {
            ++map[ch - 'A'];
        }
        Arrays.sort(map);
        int count = 0;
        for(int i=25;i>=0;--i) {
            if (map[i] == map[25]) {
                count ++;
            }
        }
        return Math.max((n+1) * (map[25]-1) + count, tasks.length);
    }
}
