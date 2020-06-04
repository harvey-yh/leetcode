package 数学;

/**
 * @author Harvey
 * @date 2020/6/4
 * @slogan Drive business with technology, make business generate value.
 */
public class Excel表列序号 {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        s = s.toUpperCase();
        int seq = 0;
        for(int i=s.length()-1;i>=0;i--){
            seq += (s.charAt(i)-'@')*Math.pow(26, s.length()-1-i);
        }
        return seq;
    }
}
