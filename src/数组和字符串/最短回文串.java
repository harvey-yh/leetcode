package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/8/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 最短回文串 {
    public static String shortestPalindrome(String s) {
        String max = s+s;
        for(int i=0;i<s.length();i++){
            max = max.length() < helper(s,i,i).length() ? max : helper(s,i,i);
            max = max.length() < helper(s,i,i+1).length() ? max : helper(s,i,i+1);
        }
        return max;
    }
    public static String helper(String s, int i, int j){
        StringBuilder res = new StringBuilder();
        res.append(s);
        while(i >= 0 || j < s.length()){
            if(i >= 0 && j < s.length()){
                if(s.charAt(i) == s.charAt(j)){
                    i--;
                    j++;
                }else{
                    return s+s;
                }
            }else if(i < 0){
                res.insert(0, s.charAt(j));
                j++;
            }else {
                return s+s;
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        System.out.println(shortestPalindrome("abcd"));
    }
}
