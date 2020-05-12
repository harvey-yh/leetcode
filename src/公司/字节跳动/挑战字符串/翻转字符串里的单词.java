package 公司.字节跳动.挑战字符串;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 翻转字符串里的单词 {
    public String reverseWords(String s) {
        String[]  strs = s.trim().split(" ");
        StringBuffer res = new StringBuffer();
        for(int i=strs.length-1; i>=0; i--){
            if(strs[i].trim().length() > 0){
                res.append(strs[i]).append(" ");
            }
        }
        return res.toString().trim();
    }
}
