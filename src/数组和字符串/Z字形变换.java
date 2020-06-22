package 数组和字符串;

import com.sun.rowset.internal.Row;

/**
 * @author Harvey
 * @date 2020/6/22
 * @slogan Drive business with technology, make business generate value.
 */
public class Z字形变换 {
    public static String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }

    public static String convert1(String s, int numRows) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(numRows == 1){
            return s;
        }
//        int m = 2 * s.length() / numRows > 0 ? 2 * s.length() / numRows : 1;
        Character[][] chs = new Character[numRows][s.length()];
        int[][] dict = new int[][]{{1,0},{-1, 1}};
        int i = 0, j = 0, t = 0, x = 0;
        StringBuilder sb = new StringBuilder();
        while(t < s.length()){
            chs[i][j] = s.charAt(t);
            if(i+dict[x%2][0] >= numRows || i+dict[x%2][0] < 0){
                x++;
            }
            i+=dict[x%2][0];
            j+=dict[x%2][1];
            t++;
        }
        for(i=0;i<chs.length;i++){
            for(j=0;j<chs[0].length;j++){
                if(chs[i][j] != null){
                    sb.append(chs[i][j]);
                }
            }
        }
        return sb.toString();

    }
    public static void main(String[] args){
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
