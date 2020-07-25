package 设计;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/7
 * @slogan Drive business with technology, make business generate value.
 */
public class BrowserHistory {
    private List<String> list = new ArrayList<>();
    private int cur = 0;
    private BrowserHistory(String homepage) {
        list.add(homepage);
    }

    private void visit(String url) {
        while(cur + 1 < list.size()){
            list.remove(list.size() - 1);
        }
        cur++;
        list.add(url);
    }

    private String back(int steps) {
        cur = Math.max(0, cur - steps);
        return list.get(cur);
    }

    private String forward(int steps) {
        cur = Math.min(list.size() - 1, cur + steps);
        return list.get(cur);
    }
    public static void main(String[] args){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1));                 // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1));                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1));                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2));                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2));                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}
