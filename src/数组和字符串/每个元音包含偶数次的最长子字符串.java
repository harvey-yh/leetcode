package 数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/5/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 每个元音包含偶数次的最长子字符串 {
    public static int findTheLongestSubstring(String s) {
        int sum = 0, max = 0;

        int[] st = new int[32];
        Arrays.fill(st, -1);
        st[0] = 0;

        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            switch(ch[i]){
                case 'a' : sum ^= 1; break;
                case 'e' : sum ^= 2; break;
                case 'i' : sum ^= 4; break;
                case 'o' : sum ^= 8; break;
                case 'u' : sum ^= 16; break;
            }
            if(st[sum] < 0) {
                st[sum] = i+1;
            }
            max = Math.max(max, i+1-st[sum]);
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));

    }
}
