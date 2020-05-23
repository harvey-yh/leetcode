package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 最小覆盖子串 {
    public static String minWindow(String s, String t) {
        int count = t.length();
        int[] map = new int[128];
        for(char c: t.toCharArray()){
            map[c]++;
        }
        int left = 0, right = 0, begin = 0, min = Integer.MAX_VALUE;
        while(right< s.length()){
            if(map[s.charAt(right)]>0){
                count--;
            }
            map[s.charAt(right)]--;
            right++;
            while(count == 0){
                if(right-left<min){
                    min = right-left;
                    begin = left;
                }
                if(map[s.charAt(left)] == 0){
                    count++;
                }
                map[s.charAt(left++)]++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin+min);
    }
    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
