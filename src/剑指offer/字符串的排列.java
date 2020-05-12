package 剑指offer;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/5/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串的排列 {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String s) {
        char[] chs = s.toCharArray();
        dfs(chs, 0);
        res.sort(String::compareTo);
        return res;
    }
    void dfs(char[] chs, int x) {
        if(x == chs.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(chs));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < chs.length; i++) {
            // 重复，因此剪枝
            if(set.contains(chs[i])) {
                continue;
            }
            set.add(chs[i]);
            // 交换，将 c[i] 固定在第 x 位
            swap(chs, i, x);
            // 开启固定第 x + 1 位字符
            dfs(chs,x + 1);
            // 恢复交换
            swap(chs, i, x);
        }
    }
    void swap(char[] chs, int a, int b) {
        char tmp = chs[a];
        chs[a] = chs[b];
        chs[b] = tmp;
    }

//    public ArrayList<String> Permutation(String str){
//        ArrayList<String> list = new ArrayList<String>();
//        if(str==null || str.length()==0){
//            return list;
//        }
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        list.add(String.valueOf(chars));
//        int len = chars.length;
//        while(true){
//            int lIndex = len-1;
//            int rIndex;
//            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
//                lIndex--;
//            }
//            if(lIndex == 0) {
//                break;
//            }
//            rIndex = lIndex;
//            while(rIndex<len && chars[rIndex]>chars[lIndex-1]){
//                rIndex++;
//            }
//            swap(chars,lIndex-1,rIndex-1);
//            reverse(chars,lIndex);
//
//            list.add(String.valueOf(chars));
//        }
//        return list;
//    }
//
//    private void reverse(char[] chars,int k){
//        if(chars==null || chars.length<=k) {
//            return;
//        }
//        int len = chars.length;
//        for(int i=0;i<(len-k)/2;i++){
//            int m = k+i;
//            int n = len-1-i;
//            if(m<=n){
//                swap(chars,m,n);
//            }
//        }
//    }
//
//    private void swap(char[] cs,int i,int j){
//        char temp = cs[i];
//        cs[i] = cs[j];
//        cs[j] = temp;
//    }
}
