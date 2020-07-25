package 设计;

/**
 * @author Harvey
 * @date 2020/7/25
 * @slogan Drive business with technology, make business generate value.
 */
public class Trie {
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){    //插入单词
        TrieNode node = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word){//查找单词
        TrieNode node = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix){//查找前缀
        TrieNode node = root;
        char[] pres = prefix.toCharArray();
        for (char p : pres) {
            if (node.next[p - 'a'] == null) {
                return false;
            }
            node = node.next[p - 'a'];
        }
        return true;
    }
}
