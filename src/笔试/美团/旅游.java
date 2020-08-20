package 笔试.美团;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 旅游 {
    /**
     * 小团是一个旅游爱好者，快要过春节了，他想统计一下，在过去的一年中他进行过几次旅行，于是他打开了美团app的订单记录，
     * 记录显示了他的购买车票的记录。记录是按时间顺序给出的，已知一次旅行的线路一定是一个闭环，即起点和终点是同一个地点。
     * 因此当每找到一段闭合的行程，即认为完成了一次旅行。数据保证不会出现不在闭环路径中的数据。
     * 请你在小团的购票记录中统计出他全年共进行了多少次旅行？
     *
     * 输入第一行包含一个正整数n，表示小团的购票记录数量。(1<=n<=10000)
     * 接下来有n行，每行是两个长度不超过10的仅由小写字母组成的字符串S_a S_b，表示购买了一张从S_a到S_b的车票。
     *
     * 输出仅包含一个整数，表示小团的旅行次数。
     *
     * 6
     * beijing nanjing
     * nanjing guangzhou
     * guangzhou shanghai
     * shanghai beijing
     * fuzhou beijing
     * beijing fuzhou
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] travel = new String[n][2];
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            travel[i][0] = sc.next();
            travel[i][1] = sc.next();
            if(!map.containsKey(travel[i][0])){
                map.put(travel[i][0], new ArrayList<>());
            }
            map.get(travel[i][0]).add(travel[i][1]);
        }


    }
}
