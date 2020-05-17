package 图;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/5/17
 * @slogan Drive business with technology, make business generate value.
 */
public class 课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
            if(!map.containsKey(p[1])){
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;
            if(map.containsKey(curr)){
                for(int i : map.get(curr)){
                    inDegrees[i]--;
                    if (inDegrees[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }

    /**
     * hashset 作为邻接矩阵
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        // HashSet 作为邻接矩阵
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
        }
        // 标记数组
        int[] mark = new int[numCourses];
        // 结果栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if(!isCycle(graph, mark, i, stack)) {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private boolean isCycle(HashSet<Integer>[] graph, int[] mark, int i, Stack<Integer> stack) {
        if (mark[i] == -1) {
            return true;
        }
        if (mark[i] == 1) {
            return false;
        }
        mark[i] = 1;
        for (int neighbor : graph[i]) {
            if (!isCycle(graph, mark, neighbor, stack)) {
                return false;
            }
        }
        mark[i] = -1;
        stack.push(i);
        return true;
    }
}
