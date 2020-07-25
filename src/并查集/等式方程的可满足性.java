package 并查集;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 等式方程的可满足性 {
    private static int[] parent;
    private static boolean equationsPossible(String[] equations) {
        if(equations == null || equations.length == 0){
            return false;
        }
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(equation.charAt(0) - 'a') == find(equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    private static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public static void main(String[] args){
        System.out.println(equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }
}
