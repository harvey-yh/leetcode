package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/3/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 实现strStr {
    /**
     * 超时
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length()==0){
            return 0;
        }

        int p1=0, p2=0, last=0;
        while(p1 <= haystack.length()-needle.length()){
            if(haystack.charAt(p1) == needle.charAt(0)){
                int x = p1+1,y=1;
                for(int i=1;i<needle.length();i++){
                    if(haystack.charAt(x) != needle.charAt(i)){
                        break;
                    }
                    x++;
                    y++;
                }
                if(y!=needle.length()){
                    continue;
                }else{
                    return p1;
                }
            }
            p1++;
        }
        return -1;
    }
    public static int strStr1(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if(needle.equals("") || needle == null){
            return 0;
        }
        if(len2 > len1){
            return -1;
        }
        for(int i=0;i<=len1-len2;i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(haystack.substring(i,i+len2).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
        // API解法
//        return = haystack.indexOf(needle);
    }
    public static void main(String[] args){
        System.out.println(strStr("mississippi","issip"));
    }
}
