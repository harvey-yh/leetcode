package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 外观数列 {
    public static String countAndSay(int n) {
        if(n==1){return "1";}
        if(n==2){return "11";}
        if(n==3){return "12";}
        if(n==4){return "1211";}
        if(n==5){return "111221";}
        StringBuilder res = new StringBuilder("111221");
        for(int i=6;i<=n;i++){
            char[] chs = res.toString().toCharArray();
            res.delete(0,res.length());
            int count=1;
            for(int j=0;j<chs.length;j++){
                if(j==0 && chs[j] != chs[j+1]){
                    res.append(count).append(chs[j]);
                    count=1;
                }else if(j == chs.length-1){
                    res.append(count).append(chs[j]);
                }else if(chs[j] == chs[j+1]){
                    count++;
                }else{
                    res.append(count).append(chs[j]);
                    count=1;
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        System.out.println(countAndSay(8));
    }
}
