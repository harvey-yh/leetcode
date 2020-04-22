package 动态规划;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/4/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 单词拆分 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (String w : wordDict) {
            int t = w.length();
            max = Math.max(max, t);
            min = Math.min(min, t);
        }

        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = min; i <= n; i++) {
            for (int j = min; j <= max; j++) {
                if (i >= j && dp[i - j] && words.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        List<String> words = new ArrayList<>();
        words.add("aaaa");
        words.add("aaa");
//        words.add("bbb");
//        words.add("bbbb");
        System.out.println(wordBreak("aaaaaaa", words));
    }
}

