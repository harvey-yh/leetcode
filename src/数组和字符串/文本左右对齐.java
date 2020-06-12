package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/6/12
 * @slogan Drive business with technology, make business generate value.
 */
public class 文本左右对齐 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        if(words == null || words.length == 0){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int maxlen = 0, num = 0;
        for(int i=0;i<words.length;i++){
            if(maxlen + words[i].length() + (num - 1) + 1 > maxWidth){
                // 总的需要添加的空格数量
                int x = maxWidth - maxlen;
                // 单词之间需要添加的空格数量
                int space = num-1 > 0 ? x / (num-1) : x;
                StringBuilder sp = new StringBuilder();
                for(int j=0;j<space;j++){
                    sp.append(" ");
                }
                // 空格数不能平均分配时，需要对多余的空格从左到右进行分配
                int mod = num-1 > 0 ? x % (num-1) : 0;
                StringBuilder sb = new StringBuilder();
                if(num == 1){
                    sb.append(tmp.get(0)).append(sp.toString());
                    res.add(sb.toString());
                }else{
                    for(int j = 0;j<tmp.size();j++){
                        if(mod > 0){
                            sb.append(tmp.get(j)).append(sp.toString()).append(" ");
                            mod--;
                        }else{
                            sb.append(tmp.get(j)).append(sp.toString());
                        }
                    }
                    res.add(sb.toString().trim());
                }
                tmp.clear();
                maxlen = 0;
                num = 0;
            }
            tmp.add(words[i]);
            maxlen += words[i].length();
            num++;
            if(i == words.length - 1){
                int x = maxWidth - maxlen - (num-1);
                StringBuilder sp = new StringBuilder();
                for(int j = 0; j < x; j++){
                    sp.append(" ");
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < tmp.size(); j++){
                    sb.append(tmp.get(j)).append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append(sp.toString());
                res.add(sb.toString());
            }
        }
        return res;
    }
    public static void main(String[] args){
        String[] words = new String[]{"a"};
        System.out.println(fullJustify(words, 1));
    }
}
