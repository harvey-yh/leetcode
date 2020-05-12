package 公司.字节跳动.挑战字符串;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if(count != 0){
            prefix = strs[0];
        }
        for(int i=1; i<count; i++){
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
}
