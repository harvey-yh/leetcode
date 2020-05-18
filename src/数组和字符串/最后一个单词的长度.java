package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 最后一个单词的长度 {
    public static int lengthOfLastWord(String s) {
//        if(s == null || s.equals("")){
//            return 0;
//        }
//        String[] strs = s.split(" +");
//        return strs.length == 0 ? 0 : strs[strs.length - 1].length();
        if(s == null || s.equals("")){
            return 0;
        }
        int i=s.length() - 1;
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        int res = 0;
        for(;i>=0;i--){
            if(s.charAt(i) != ' '){
                res++;
            }else{
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("a"));
    }
}
