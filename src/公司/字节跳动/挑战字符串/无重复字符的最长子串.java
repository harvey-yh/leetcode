package 公司.字节跳动.挑战字符串;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int x=0,y=0;
        int len=1;
        char[] array = s.toCharArray();
        if(s.equals("") ){
            return 0;
        }
        while(y<s.length()-1){
            y++;
            for(int i=x;i<y;i++){
                if(array[y] == array[i]){
                    x=i+1;
                    break;
                }
            }
            len = len>(y-x+1)?len:(y-x+1);
        }
        return len;
    }
}
