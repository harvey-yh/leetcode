package 贪心算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1=0, p2=0;
        int res = 0;
        while(p1<g.length && p2 <s.length){
            if(s[p2] >= g[p1]){
                res++;
                p1++;
                p2++;
            }else{
                p2++;
            }
        }
        return res;
    }
}
