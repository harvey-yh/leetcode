package 剑指offer;

import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 左旋转字符串 {
    /**
     * abcXYZdef    ----->     XYZdefabc
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str,int n) {
        if(str == null || str.equals("") || n == 0){
            return str;
        }
        LinkedList<Character> res = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            res.add(str.charAt(i));
        }
        while(n > 0){
            char c = res.pollFirst();
            res.addLast(c);
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.size(); i++){
            sb.append(res.get(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }
}
