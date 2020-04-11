package 贪心算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/4/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 去除重复字母 {
    /**
     * c b a c d c b c
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        HashSet<Character> seen = new HashSet<>();

        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!seen.contains(c)){
                while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters1(String data) {
        if (data == null || data.length() == 0) {
            return "";
        }

        // 用于标记字符是否已经在队列
        boolean[] exist = new boolean[26];
        // 字符记数器，在降字典序时用于判断是否最后一次出现
        int[] counter = new int[26];

        char[] eles = data.toCharArray();
        for (char ele : eles) {
            counter[ele - 'a']++;
        }

        // 输出队列,最多26个字符
        char[] pool = new char[26];
        int poolSite = 0;

        // 初始队列，不计入计数器
        exist[eles[0] - 'a'] = true;
        pool[0] = eles[0];
        poolSite++;

        for (char ele : eles) {
            counter[ele - 'a']--;

            // 已存在的字符不重复计入
            if (exist[ele - 'a']) {
                continue;
            }

            // 降字典序
            char end = pool[poolSite - 1];
            while (end > ele) {
                // 不再出现的字符不可清除
                if (counter[end - 'a'] == 0) {
                    break;
                }
                poolSite--;
                exist[end - 'a'] = false;
                // 队列清空，无法继续降字典序
                if (poolSite == 0) {
                    break;
                }
                end = pool[poolSite - 1];
            }

            exist[ele - 'a'] = true;
            pool[poolSite] = ele;
            poolSite++;
        }

        StringBuilder result = new StringBuilder();
        for (int site = 0; site < poolSite; site++) {
            result.append(pool[site]);
        }

        return result.toString();
    }
}
