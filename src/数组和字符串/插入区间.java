package 数组和字符串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/5/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();

        while (idx < n && newStart > intervals[idx][0]) {
            output.add(intervals[idx++]);
        }

        int[] interval;
        if (output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);

    }
}
