package 笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 汽车调度 {
    /**
     * 小团是美团汽车租赁公司的调度师，某个时刻A和B两地都向该公司提交了租车的订单，分别需要a和b辆汽车。此时，公司的所有车辆都在外运营，通过北斗定位，可以得到所有车辆的位置，小团分别计算了每辆车前往A地和B地完成订单的利润。作为一名精明的调度师，当然是想让公司的利润最大化了。
     *
     * 请你帮他分别选择a辆车完成A地的任务，选择b辆车完成B地的任务。使得公司获利最大,每辆车最多只能完成一地的任务。
     * 输入第一行包含三个整数n，a，b，分别表示公司的车辆数量和A，B两地订单所需数量,保证a+b<=n。(1<=n<=2000)
     *
     * 接下来有n行，每行两个正整数x，y，分别表示该车完成A地任务的利润和B地任务的利润。
     *
     * 输出仅包含一个正整数，表示公司最大获得的利润和。
     * 5 2 2
     * 4 2
     * 3 3
     * 5 4
     * 5 3
     * 1 5
     *
     * 18
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] x = new int[n][3];
        int[][] y = new int[n][3];
        for(int i=0;i<n;i++){
            x[i][0] = sc.nextInt();
            x[i][1] = sc.nextInt();
            x[i][2] = i;
            y[i][0] = x[i][0];
            y[i][1] = x[i][1];
            y[i][2] = i;
        }
        boolean[] used = new boolean[n];
        Arrays.sort(x, (o1, o2)->o1[0] == o2[0] ? o2[1]-o1[1] : o2[0]-o1[0]);
        Arrays.sort(y, (o1,o2)->o1[1] == o2[1] ? o2[0]-o1[0] : o2[1]-o1[1]);
        /**
         * 5 4
         * 5 3
         * 4 2
         * 3 3
         * 1 5
         *
         * 1 5
         * 5 4
         * 5 3
         * 3 3
         * 4 2
         */
        long res = 0;
        int t1=0, t2 =0;
        int count = 0;
        while(count < a+b){
            if(t1 >= a){
                if(!used[y[t2][2]]){
                    used[y[t2][2]] = true;
                    res += y[t2][1];
                    t2++;
                    count++;
                }else{
                    t2++;
                }
                continue;
            }
            if(t2 >= b){
                if(!used[x[t1][2]]){
                    used[x[t1][2]] = true;
                    res += x[t1][0];
                    t1++;
                    count++;
                }else{
                    t1++;
                }
                continue;
            }
            if(t1 < a && x[t1][0] >= y[t2][1]){
                if(!used[x[t1][2]]){
                    used[x[t1][2]] = true;
                    res += x[t1][0];
                    t1++;
                    count++;
                }
            }else if(t2 < b && x[t1][0] < y[t2][1]){
                if(!used[y[t2][2]]){
                    used[y[t2][2]] = true;
                    res += y[t2][1];
                    t2++;
                    count++;
                }
            }
        }
        System.out.println(res);
    }
}
