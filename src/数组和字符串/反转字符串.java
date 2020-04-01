package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 反转字符串 {
    public static void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while(l<=r){
            char tmp;
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
    public static void main(String[] args){
        char[] x = new char[]{'h','e','l','l','o'};
        reverseString(x);
        System.out.println(x);
    }
}
