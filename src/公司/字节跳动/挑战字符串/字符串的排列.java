package 公司.字节跳动.挑战字符串;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串的排列 {
    /**
     * 题意：在s2中连续的s1串长度内，出现与s1串中各个字母出现次数相同即为true
     * 解题思路：在s2的s1的框口大小内存在着与s1的所有相同数量的字母，存在一个问题如果对字母排序会影响效率，由于都是小写字母，可以考虑26个字母对应26位，
     * 每一位对应对应字母出现次数
     */
    public static boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) {
            return false;
        }

        // ·窗口固定大小，尺寸参照s1.length()
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        int size = s1.length();

        char[] s1Ch = s1.toCharArray();
        char[] s2Ch = s2.toCharArray();
        // ·s1 s2同时初始化
        for (int i = 0; i < size; i++) {
            s1Arr[(s1Ch[i] - 'a')]++;
            s2Arr[(s2Ch[i] - 'a')]++;
        }

        for (int i = s1.length(), start = 0; i < s2.length(); i++, start++) {
            if (match(s1Arr, s2Arr)) {
                return true;
            }
            // ·窗口右移
            s2Arr[(s2Ch[i] - 'a')]++;
            s2Arr[(s2Ch[start] - 'a')]--;
        }

        return match(s1Arr, s2Arr);
    }

    private static boolean match(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){

    }
}
