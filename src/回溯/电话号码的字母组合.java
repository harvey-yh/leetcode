package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 电话号码的字母组合 {
    String[] nums = new String[]{"0", "1", "abc", "def", "ghi", "fkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return res;
        }
        backtrack(digits, 0, new StringBuilder());
        return res;
    }
    public void backtrack(String digits, int start, StringBuilder path){
        if (start == digits.length()) {
            res.add(path.toString());
            return;
        }
        int num = digits.charAt(start) - '0';
        String letter = nums[num];
        for (int i = 0; i < letter.length(); i++) {
            int len = path.length();
            backtrack(digits, start + 1, path.append(letter.charAt(i)));
            path.delete(len, path.length());
        }
    }
}
