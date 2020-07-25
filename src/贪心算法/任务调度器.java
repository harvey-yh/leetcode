package 贪心算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/6/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 任务调度器 {
    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务
     *      如题得到的时间至少为 retCount =（count-1）* n + count ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval1(char[] tasks, int n) {
        int[] ch = new int[26];
        for(int i=0;i<tasks.length;i++){
            int x = tasks[i]-'A';
            ch[x] += 1;
        }
        Arrays.sort(ch);
        int max = ch[25];
        int res = max + (max-1) * n;
        int i = 24;
        while(i >= 0 && ch[i] == max){
            res++;
            i--;
        }
        return Math.max(res, tasks.length);
    }
    public static void main(String[] args){
        System.out.println(leastInterval1(new char[]{'A','A','A','B','B','B','C','C','C','D','D','D'}, 2));
    }
}
