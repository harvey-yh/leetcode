package 数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/8/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 回文对 {
    /**
     * 对于一个字符串对(x, y)(x,y), 若想要字符串x+yx+y是一个回文字符串，则必须满足以下条件之一
     * 1. 当x.length() \geq y.length()x.length()≥y.length()时, 字符串xx的y.length()y.length()长度的前缀与yy的逆序相等，且字符串xx去除长度为y.length()y.length()的前缀后，余下的部分也是一个回文字符串。
     * 2. 当x.length() < y.length()x.length()<y.length()时,与情况一正相反。
     */
    private static Node root;
    public static List<List<Integer>> palindromePairs(String[] words) {
        root = new Node();
        int n = words.length;
        // 字典树的插入，注意维护每个节点上的两个列表
        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            Node cur = root;
            // 本身是回文，添加到suffix列表中
            if (isPalindrome(rev)) {
                cur.suffixs.add(i);
            }
            for (int j = 0; j < rev.length(); j++) {
                char ch = rev.charAt(j);
                if (cur.children[ch-'a'] == null) {
                    cur.children[ch-'a'] = new Node();
                }
                cur = cur.children[ch-'a'];
                if (isPalindrome(rev.substring(j+1))) {
                    cur.suffixs.add(i);
                }
            }
            cur.words.add(i);
        }
        // 用以存放答案的列表
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];
            Node cur = root;
            int j = 0;
            for ( ;j < word.length(); j++) {
                // 到j位置，后续字符串若是回文对，则在该节点位置上所有单词都可以与words[i]构成回文对
                // 因为我们插入的时候是用每个单词的逆序插入的:)
                if(isPalindrome(word.substring(j))) {
                    for (int k : cur.words) {
                        if (k != i) {
                            ans.add(Arrays.asList(i,k));
                        }
                    }
                }

                char ch = word.charAt(j);
                if (cur.children[ch-'a'] == null) {
                    break;
                }
                cur = cur.children[ch-'a'];

            }
            // words[i]遍历完了，现在找所有大于words[i]长度且符合要求的单词，suffixs列表就派上用场了:)
            if (j == word.length()) {
                for (int k : cur.suffixs) {
                    if (k != i) {
                        ans.add(Arrays.asList(i,k));
                    }
                }
            }

        }
        return ans;

    }
    //  判断一个字符串是否是回文字符串
    private static boolean isPalindrome(String w) {
        int i = 0, j = w.length()-1;
        while (i < j) {
            if (w.charAt(i) != w.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static List<List<Integer>> palindromePairs1(String[] words) {
        int n = words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!"".equals(words[i])){
                map.put(words[i], i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if("".equals(words[i])){
                for(int j=0;j<n;j++){
                    if(isPalindrome(words[j]) &&j!=i){
                        res.add(Arrays.asList(i,j));
                        res.add(Arrays.asList(j,i));
                    }
                }
            }else{

                for(int j=0;j<words[i].length();j++){
                    //如果某个字符串能找到一个分割点，分割点后的部分是回文，前半部分翻转后也在数组里，可组成一对。
                    if(isPalindrome(words[i].substring(j))){
                        String re = new StringBuilder(words[i].substring(0,j)).reverse().toString();
                        if(map.containsKey(re) && map.get(re) != i){
                            res.add(Arrays.asList(i,map.get(re)));
                        }
                    }
                    //如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，可组成一对。
                    if(isPalindrome(words[i].substring(0,j))){
                        String re = new StringBuilder(words[i].substring(j)).reverse().toString();
                        if(map.containsKey(re) && map.get(re) != i){
                            res.add(Arrays.asList(map.get(re), i));
                        }
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(palindromePairs1(new String[]{"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"}));
    }
}
class Node {
    public Node[] children;
    //存储以当前节点为终止节点的所有单词（逆序之后的),来获取所有第1种情况下的匹配成功的字符串yy
    public List<Integer> words;
    //保存所有到当前节点为止，其之后剩余字符可以构成回文对的单词。用来获取所有长度大于x.length()x.length()，且可以和其构成回文对的单词yy（即针对第二种情况）。
    public List<Integer> suffixs;
    public Node() {
        this.children = new Node[26];
        this.words = new ArrayList<>();
        this.suffixs = new ArrayList<>();
    }
}
