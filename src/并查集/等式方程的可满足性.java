package 并查集;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 等式方程的可满足性 {
    public static boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        Arrays.stream(parent).forEach(System.out::println);
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    public static void main(String[] args){
        System.out.println(equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }
}
