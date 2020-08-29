package 深度或广度优先搜索;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/8/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 重新安排行程 {
    static Map<String, PriorityQueue<String>> map = new HashMap<>();
    static List<String> list = new LinkedList<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), des = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(des);
        }
        dfs("JFK");
        Collections.reverse(list);
        return list;
    }

    public static void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        list.add(curr);
    }
    public static void main(String[] args){
        List<List<String>> tickets = new ArrayList<>();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        List<String> c = new ArrayList<>();
        List<String> d = new ArrayList<>();
        List<String> e = new ArrayList<>();
        a.add("JFK");
        a.add("SFO");
        b.add("JFK");
        b.add("ATL");
        c.add("SFO");
        c.add("ATL");
        d.add("ATL");
        d.add("JFK");
        e.add("ATL");
        e.add("SFO");
        tickets.add(a);
        tickets.add(b);
        tickets.add(c);
        tickets.add(d);
        tickets.add(e);
        List<String> list = findItinerary(tickets);
        list.forEach(System.out::println);
    }
}
