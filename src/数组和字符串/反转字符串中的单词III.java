package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(String str : strs){
            sb.append(new StringBuilder(str).reverse().toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
