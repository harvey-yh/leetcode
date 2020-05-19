package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Harvey
 * @date 2020/5/19
 * @slogan Drive business with technology, make business generate value.
 */
public class 和为S的连续整数序列 {
    /**
     * 数学计算
     * 从个数出发，t个数能组成sum的话，那么 x1+x2+...+xt = sum，转化一下 —> t*x1 + (t-1)*t/2 = sum
     * 所以 x1 = (sum - (t - 1) * t / 2) / t ,若x1为整数，那么即以x1为首数的t个数的和能组成sum。
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        int x1;
        int t = 2;
        while(true){
            if((sum - (t - 1) * t / 2) % t == 0){
                x1 = (sum - (t - 1) * t / 2) / t ;
                if(x1 > 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=0;i<t;i++){
                        list.add(x1+i);
                    }
                    res.add(list);
                }else{
                    Collections.reverse(res);
                    return res;
                }
            }
            t++;
        }
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(FindContinuousSequence(9));
    }
}
