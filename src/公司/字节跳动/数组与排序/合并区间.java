package 公司.字节跳动.数组与排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> res = new ArrayList<>();
        int l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > r) {
                res.add(new int[] {l ,r});
                l = intervals[i][0];
                r = intervals[i][1];

            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }
        res.add(new int[] {l ,r});
        return res.toArray(new int[0][]);
    }
    public int[][] merge1(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return intervals;
        }
        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2)->o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= res.get(res.size()-1)[1]){
                int max = Math.max(intervals[i][1], res.get(res.size()-1)[1]);
                res.get(res.size() - 1)[1] = max;
            } else{
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        return res.toArray(new int[0][]);
    }
}
