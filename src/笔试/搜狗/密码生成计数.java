package 笔试.搜狗;

import java.util.HashSet;

/**
 * @author Harvey
 * @date 2020/9/5
 * @slogan Drive business with technology, make business generate value.
 */
public class 密码生成计数 {
    /**
     * 密码生成计数
     * 70%
     */
    static int res = 0;
    public static long getPasswordCount (String password) {
        for(int i=0;i<=9;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            dfs(password, sb, i, 1);
        }
        return res;
    }
    public static void dfs(String password, StringBuilder sb, int x, int i){
        if(i == password.length()){
            if(!sb.toString().equals(password)){
                res++;
            }
            return ;
        }
        int t = (password.charAt(i) - '0' + x) / 2;
        if((password.charAt(i) - '0' + x) % 2 == 0){
            sb.append(t);
            dfs(password, sb, t, i+1);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(t);
            dfs(password, sb, t, i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append(t + 1);
            dfs(password, sb, t+1, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(getPasswordCount("12345"));
    }
}
