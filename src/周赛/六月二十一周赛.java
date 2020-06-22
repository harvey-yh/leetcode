package 周赛;


import java.util.*;

/**
 * @author Harvey
 * @date 2020/6/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 六月二十一周赛 {

    /**
     * 5441. 保证文件名唯一
     * @param names
     * @return
     */
    static Map<String, Integer> cnt = new HashMap<>();
    public static String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        for (int i = 0; i < ans.length; i++) {
            String name = names[i];
            if (cnt.containsKey(name)) {
                ans[i] = name + "(" + cnt.get(name) + ")";
                while (cnt.containsKey(ans[i])) {
                    cnt.put(name, cnt.getOrDefault(name, 0) + 1);
                    ans[i] = name + "(" + cnt.get(name) + ")";
                }
            } else {
                ans[i] = name;
            }
            cnt.put(ans[i], cnt.getOrDefault(ans[i], 0) + 1);
        }
        return ans;
    }

    /**
     * 5442. 避免洪水泛滥
     * @param rains
     * @return
     */
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> registries = new HashMap<>(n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            next[i] = registries.getOrDefault(rains[i], n);
            registries.put(rains[i], i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<Rain> pq = new PriorityQueue<>(n, (a, b) -> Integer.compare(a.day, b.day));
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                if (!pq.isEmpty()) {
                    ans[i] = pq.remove().index;
                }else{
                    ans[i] = 1;
                }
            } else {
                Rain rain = new Rain();
                rain.index = rains[i];
                rain.day = next[i];
                pq.add(rain);
            }
            if (!pq.isEmpty() && pq.peek().day <= i) {
                return new int[0];
            }
        }
        return ans;
    }
    class Rain {
        int index;
        int day;
    }
    public static void main(String[] args){
        System.out.println(getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"}));
    }
}
