package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        if(str == null || str.equals("") || str.trim().equals("")){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split(" +");
        for(int i=strs.length-1;i>=0;i--){
            sb.append(strs[i]).append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
}
