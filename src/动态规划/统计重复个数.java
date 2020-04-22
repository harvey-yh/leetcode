package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 统计重复个数 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0) {
            return 0;
        }
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        int len1 = s1.length(), len2 = s2.length();
        int couts1=0, couts2=0;
        //当前在s2的位置
        int p=0;
        //记录每一次s1扫描结束后当前的状态，寻找循环
        Map<Integer,int[]> map = new HashMap<>();
        while(couts1<n1){
            for(int i=0;i<len1;i++){
                if(c1[i]==c2[p]){
                    p++;
                    if(p==len2){
                        p=0;
                        couts2++;
                    }
                }
            }
            couts1++;
            if(!map.containsKey(p)){
                map.put(p,new int[]{couts1,couts2});
            }else{//出现了循环 这次结束后p的位置和以前某一次一样，就是循环
                int[] last =map.get(p);
                int circle1= couts1-last[0];
                int circle2= couts2-last[1];
                couts2 += circle2*((n1-couts1)/circle1);
                couts1 = couts1+((n1-couts1)/circle1)*circle1;
            }
        }
        return couts2/n2;
    }
}
