package 二分查找;

/**
 * @author Harvey
 * @date 2020/7/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0){
            return true;
        }
        if(t == null || t.length() == 0 || s.length() > t.length()){
            return false;
        }
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
//        int i=  s.length()-1, j = t.length()-1;
//        while(i >= 0 && j >= 0){
//            if(t.charAt(j) == s.charAt(i)){
//                i--;
//                j--;
//            }else{
//                j--;
//            }
//        }
//        return i < 0;
    }

}
