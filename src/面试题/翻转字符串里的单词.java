package 面试题;

/**
 * @author Harvey
 * @date 2020/4/10
 * @slogan Drive business with technology, make business generate value.
 */
public class 翻转字符串里的单词 {
    /**
     * 使用正则
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.trim().split("\\s+");
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseWords1(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=arr.length - 1;i>=0;i--){
            if("".equals(arr[i])){
                continue;
            }
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args){
        System.out.println(reverseWords("a good   example"));
    }
}
