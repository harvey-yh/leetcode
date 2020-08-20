package 笔试.用友;

/**
 * @author Harvey
 * @date 2020/8/18
 * @slogan Drive business with technology, make business generate value.
 */
public class 压缩字符串 {
    public static String compress (String str) {
        if(str == null || str.length() == 0){
            return "";
        }
        String tmp = str;
        int t = 1;
        char c = tmp.charAt(0);
        int i=1;
        StringBuilder sb = new StringBuilder();
        while(i < tmp.length()){
            if(tmp.charAt(i) == c){
                t++;
            }else{
                sb.append(c).append(t);
                t = 1;
                c = tmp.charAt(i);
            }
            i++;
        }
        sb.append(c).append(t);
        return sb.toString().length() > str.length() ? str : sb.toString();
    }
}
