package 数据结构;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Harvey
 * @date 2020/6/29
 * @slogan Drive business with technology, make business generate value.
 */
/**
 * 字典树的节点类型
 */
class TrieNode{
    char ch;
    int freq;
    Map<Character, TrieNode> nodeMap;

    public TrieNode(char ch, int freq, Map<Character, TrieNode> nodeMap) {
        this.ch = ch;
        this.freq = freq;
        this.nodeMap = nodeMap;
    }
}

/**
 * 记录单词出现次数
 * 描述: 字典树的实现
 */
public class 字典树 {
    private TrieNode root = new TrieNode('\u0000', 0, new HashMap<>());

    /**
     * 查询str字符串是否存在，不存在返回0，存在返回该字符串的个数
     * @param str
     * @return
     */
    public int query(String str){
        TrieNode cur=root;
        if(root==null){
            return 0;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return 0;
            }else {
                cur = child;
            }
        }
        return cur.freq;
    }
    /**
     *添加单词
     */
    public void add(String str){
        TrieNode cur=root;
        if(root==null){
            return;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                TrieNode node=new TrieNode(str.charAt(i),0,new HashMap<>());
                cur.nodeMap.put(str.charAt(i),node);
                cur=cur.nodeMap.get(str.charAt(i));
            }else{
                cur=child;
            }
        }
        cur.freq++;
    }

    /**
     * 判断str是否存在
     * @param str
     * @return
     */

    public boolean search(String str){
        TrieNode cur=root;
        if(root==null){
            return false;
        }
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child==null){
                return false;
            }else {
                cur = child;
            }
        }
        return true;
    }


    /**
     * 删除str字符串
     * 三种情况
     *
     */
    public void remove(String str) {
        if(!search(str)){
            return;
        }
        TrieNode cur=root;
        TrieNode delPreNode=root;
        char delch=str.charAt(0);
        for(int i=0;i<str.length();i++){
            TrieNode child=cur.nodeMap.get(str.charAt(i));
            if(child.nodeMap==null){
                return;
            }else if(i<str.length()-1 && (child.nodeMap.get(str.charAt(i+1))!=null) && child.nodeMap.size()>0){
                delPreNode=child;
                delch=str.charAt(i+1);
            }
            cur=child;
        }
        if(cur.nodeMap.size()>0){
            cur.freq=0;
        }else{
            cur.nodeMap.remove(delch);
        }
    }
}
