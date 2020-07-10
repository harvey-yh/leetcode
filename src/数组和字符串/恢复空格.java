package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/7/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 恢复空格 {

//    /** 自定义一个TrieNode类型。
//     * 这里不用建一个变量来存当前节点表示的字符，
//     * 因为只要该节点不为null，就说明存在这个字符
//     */
//    class TrieNode{
//        TrieNode[] childs;
//        boolean isWord;
//        public TrieNode(){
//            childs = new TrieNode[26];
//            isWord = false;
//        }
//    }
//    //空白的根节点，设为全局变量更醒目
//    TrieNode root;
//    public int respace(String[] dictionary, String sentence){
//        root = new TrieNode();
//        makeTrie(dictionary);   //创建字典树
//        int n = sentence.length();
//        int[] dp = new int[n+1];
//        //这里从sentence最后一个字符开始
//        for(int i=n-1; i>=0; i--){
//            dp[i] = n-i;    //初始默认后面全不匹配
//            TrieNode node = root;
//            for(int j=i; j<n; j++){
//                int c = sentence.charAt(j)-'a';
//                if(node.childs[c] == null){
//                    //例如"abcde",i=1,j=2 可找出长度关系
//                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
//                    break;
//                }
//                if(node.childs[c].isWord){
//                    dp[i] = Math.min(dp[i], dp[j+1]);
//                } else{
//                    dp[i] = Math.min(dp[i], j-i+1+dp[j+1]);
//                }
//                node = node.childs[c];
//            }
//        }
//        return dp[0];
//    }
//
//    private void makeTrie(String[] dictionary){
//        for(String str: dictionary){
//            TrieNode node = root;
//            for(int k=0; k<str.length(); k++){
//                int i = str.charAt(k)-'a';
//                if(node.childs[i] == null){
//                    node.childs[i] = new TrieNode();
//                }
//                node = node.childs[i];
//            }
//            node.isWord = true;
//        }
//    }

    public static int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    static class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }
    public static void main(String[] args){
        System.out.println(respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother"));
    }
}
