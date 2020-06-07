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
//    LinkedList<String> list = new LinkedList<>();
//    HashMap<String, Integer> map = new HashMap<>();
//    int index = -1;
//    public BrowserHistory(String homepage) {
//        list.add(homepage);
//        map.put(homepage, list.indexOf(homepage));
//        index++;
//    }
//
//    public void visit(String url) {
//        if(map.containsKey(url)){
//            list.remove(url);
//            list.add(url);
//            map.put(url, 1);
//        }else{
//            for(int i=index+1;i<list.size();i++){
//                map.remove(list.get(i));
//                list.remove(i);
//                i--;
//            }
//            list.add(url);
//            map.put(url, 1);
//            index = list.indexOf(url);
//        }
//    }
//
//    public String back(int steps) {
//        int i = index;
//        int end = index-steps <= 0 ? 0 : index-steps;
//        for(;i > end ;i--){
//        }
//        index = i;
//        System.out.println(list.get(i));
//        return list.get(i);
//    }
//
//    public String forward(int steps) {
//        int i = index;
//        int start = index+steps > list.size()-1 ? list.size()-1 : index+steps;
//        for(;i < start ;i++){
//        }
//        index = i;
//        System.out.println(list.get(i));
//        return list.get(i);
//
//    }

    List<String> list = new ArrayList();
    int cur = 0;
    public BrowserHistory(String homepage) {
        list.add(homepage);
    }

    public void visit(String url) {
        while(cur + 1 < list.size()){
            list.remove(list.size() - 1);
        }
        cur++;
        list.add(url);
    }

    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return list.get(cur);
    }

    public String forward(int steps) {
        cur = Math.min(list.size() - 1, cur + steps);
        return list.get(cur);
    }
    public static void main(String[] args){
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}
