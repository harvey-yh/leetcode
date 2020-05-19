package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 验证回文字符串II {
    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int x, y;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                x = i + 1;
                y = j;
                while(x < y) {
                    if(s.charAt(x) != s.charAt(y)) {
                        x = i;
                        y = j - 1;
                        while(x < y) {
                            if(s.charAt(x) != s.charAt(y)) {
                                return false;
                            }
                            x++;
                            y--;
                        }
                        return true;
                    }
                    x++;
                    y--;
                }
                return true;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        int size = s.length();
        int l = 0, r = size - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        return solve(l, r - 1, s) || solve(l + 1, r, s);
    }

    private boolean solve(int i, int j, String s) {
        int l = i, r = j;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(validPalindrome("abc"));
    }
}
