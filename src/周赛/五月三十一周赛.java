package 周赛;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 五月三十一周赛 {
    /**
     * 5424.数组中两元素的最大乘积
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        return (nums[nums.length-1]-1) * (nums[nums.length-2]-1);

    }

    /**
     * 5425.切割后面积最大的蛋糕
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max1= 0, max2 = 0;
        int m=horizontalCuts.length, n=verticalCuts.length;
        max1 = getMax(max1, horizontalCuts[0]);
        for(int i = 0;i<m-1;i++){
            max1 = getMax(max1, horizontalCuts[i+1] - horizontalCuts[i]);
        }
        max1 = getMax(max1, h - horizontalCuts[m-1]);

        max2 = getMax(max2, verticalCuts[0]);
        for(int i = 0;i<n-1;i++){
            max2 = getMax(max2, verticalCuts[i+1] - verticalCuts[i]);
        }
        max2 = getMax(max2, w - verticalCuts[n-1]);
        return (int) ((max1 * max2) % (1000000007));
    }

    public static long getMax(long a, long b){
        return a > b ? a : b;
    }

    /**
     * 5426.重新规划路线
     * @param n
     * @param connections
     * @return
     */
    public static int minReorder(int n, int[][] connections) {
        int[] list = new int[n];
        list[0] = 1;
        int res = 0;
        for(int[] node : connections){
            if(list[node[1]] == 1){
                list[node[0]] = 1;
            }else{
                list[node[1]] = 1;
                res++;
            }
        }
        return res;
    }

    /**
     * 5427.两个盒子中球的颜色数相同的概率
     * @param balls
     * @return
     */
    public double getProbability(int[] balls) {
        return 0;
    }
}
