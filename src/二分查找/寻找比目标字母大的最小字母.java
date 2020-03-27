package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return letters[l % letters.length];

    }
}
