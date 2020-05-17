package 周赛;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Harvey
 * @date 2020/5/17
 * @slogan Drive business with technology, make business generate value.
 */
public class 五月十七周赛 {
    public static void main(String[] args){
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.get(0).add("leetcode");
        list.get(0).add("google");
        list.get(0).add("facebook");
        list.get(1).add("google");
        list.get(1).add("microsoft");
        list.get(2).add("google");
        list.get(2).add("facebook");
        list.get(3).add("google");
        list.get(4).add("amazon");
        System.out.println(peopleIndexes(list));
    }
    /**
     * 在既定时间做作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if(startTime == null || endTime == null || startTime.length == 0 || endTime.length == 0 || startTime.length != endTime.length){
            return 0;
        }
        int res = 0;
        for(int i=0;i<startTime.length;i++){
            if(queryTime >= startTime[i] && queryTime <= endTime[i]){
                res++;
            }
        }
        return res;
    }
    // *****************************************************************************************************************
    /**
     * 重新排列句子中的单词
     * @param text
     * @return
     */
    public static String arrangeWords(String text) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String s : text.split(" ")) {
            int len = s.length();
            if(!map.containsKey(len)){
                map.put(len, new ArrayList<>());
            }
            map.get(len).add(s);
        }

        StringBuilder sb = new StringBuilder(text.length());
        for (List<String> list : map.values()) {
            for (String s : list) {
                sb.append(s.toLowerCase()).append(" ");
            }
        }
        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // *****************************************************************************************************************

    /**
     * 收藏清单
     * favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
     * 输出：[0,1,4]
     * @param favoriteCompanies
     * @return
     */
    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<String>[] cast = favoriteCompanies.toArray(new List[0]);
        for (int i = 0; i < cast.length; i++) {
            cast[i] = cast[i].stream().map(x -> x.intern()).collect(Collectors.toList());
            cast[i].stream().forEach(System.out::print);
            System.out.println();
            cast[i].sort(String::compareTo);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean valid = true;
            for (int j = 0; j < n && valid; j++) {
                if (i == j) {
                    continue;
                }
                if (subset(cast[i], cast[j])) {
                    valid = false;
                }
            }
            if (valid) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean subset(List<String> a, List<String> b) {
        if (b.size() < a.size()) {
            return false;
        }
        int i = a.size() - 1;
        int j = b.size() - 1;
        while (i >= 0 && j >= 0) {
            if (b.get(j).equals(a.get(i))) {
                i--;
                j--;
                continue;
            }
            j--;
        }
        return i < 0;
    }

    // *****************************************************************************************************************

    double prec = 1e-8;
    /**
     * 圆形靶内的最大飞镖数量
     * @param points
     * @param r
     * @return
     */
    public int numPoints(int[][] points, int r) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int ans = count(points, points[0][0], points[0][1], r);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                double mx = (points[i][0] + points[j][0]) / 2.0;
                double my = (points[i][1] + points[j][1]) / 2.0;
                double dirX = points[i][0] - points[j][0];
                double dirY = points[i][1] - points[j][1];
                double sqr = Math.sqrt(dirX * dirX + dirY * dirY);
                dirX /= sqr;
                dirY /= sqr;
                double h = Math.sqrt(r * r - sqr / 2 * sqr / 2);
                double moveX = -dirY;
                double moveY = dirX;

                double centerX = mx + moveX * h;
                double centerY = my + moveY * h;
                int cnt = count(points, centerX, centerY, r);
                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }

    public int count(int[][] points, double x, double y, int r) {
        int ans = 0;
        for (int[] pt : points) {
            double dx = x - pt[0];
            double dy = y - pt[1];
            if (dx * dx + dy * dy <= r * r + prec) {
                ans++;
            }
        }
        return ans;
    }
}
