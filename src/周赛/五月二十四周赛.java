package 周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/5/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 五月二十四周赛 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 5416. 检查单词是否为句中其他单词的前缀
     * @param sentence
     * @param searchWord
     * @return
     */
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" +");
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    /**
     * 5417. 定长子串中元音的最大数目
     * @param s
     * @param k
     * @return
     */

    public static int maxVowels(String s, int k) {
        if(s == null || s.equals("") || k == 0){
            return 0;
        }
        int count = 0;
        for(int i=0;i<k;i++){
            if(valueOf(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        for(int i=k;i<s.length();i++){
            if(valueOf(s.charAt(i))){
                count++;
            }
            if(valueOf(s.charAt(i-k))){
                count--;
            }
            max = max < count ? count : max;
        }
        return max;
    }

    static boolean valueOf(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * 5418. 二叉树中的伪回文路径
     * 因为数字顺序可以调换，所以只需要看序列里面的每个数字出现的次数，是奇数，偶数就行
     *     回文串里面奇数次数只能最多有一个，偶数随意
     *     开始没看到只有九个数字，所以用了map，和count计数，我怕数字多了，map遍历上面浪费时间
     * @param root
     * @return
     */
    public int count = 0;
    public int ans = 0;
    public HashMap<Integer,Integer> map = new HashMap<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root) {
        int v = map.getOrDefault(root.val,0);
        v++;
        int t = count;
        //当前数字出现次数是奇数
        if ((v & 1) == 1) {
            count++;
        } else {//是偶数
            count--;
        }
        map.put(root.val,v);
        if (root.left == null && root.right == null) {
            //到达叶节点
            if (count <= 1) {
                ans++;
            }
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        //回溯，恢复状态
        map.put(root.val,v - 1);
        count = t;
    }

    /**
     * 5419. 两个子序列的最大点积
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int dp[][] = new int[len1 + 1][len2 + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                max = Math.max(max, dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
                dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
            }
        }
        return max;
    }

    public static void main(String[] args){
//        System.out.println(isPrefixOfWord("i love eating burger","burg" ));
        System.out.println(maxVowels("abciiidef",3 ));
    }
}

