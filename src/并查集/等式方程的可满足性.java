package 并查集;

/**
 * @author Harvey
 * @date 2020/6/8
 * @slogan Drive business with technology, make business generate value.
 */
public class 等式方程的可满足性 {
    static int[] parent;
    public static boolean equationsPossible(String[] equations) {
        if(equations == null || equations.length == 0){
            return false;
        }
        int length = equations.length;
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '='){
                union(equations[i].charAt(0)-'a', equations[i].charAt(3)-'a');
            }
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1) == '!'){
                if(find(equations[i].charAt(0)-'a') == find(equations[i].charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;

    }

    public static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static int find(int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
    public static void main(String[] args){
        System.out.println(equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }
}
