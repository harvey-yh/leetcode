package 深度或广度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/7/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 括号生成 {
    static List<String> res;
    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }
    public static void dfs(int n, int l, int r, StringBuilder sb){
        if(r == n){
            res.add(sb.toString());
        }
        if(l<n){
            dfs(n, l+1, r, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        if(r<n && r < l){
            dfs(n, l, r+1, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }
}
