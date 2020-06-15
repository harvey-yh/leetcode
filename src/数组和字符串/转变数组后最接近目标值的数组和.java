package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/6/14
 * @slogan Drive business with technology, make business generate value.
 */
public class 转变数组后最接近目标值的数组和 {
    public static int findBestValue(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        int n = arr.length, sum = 0, res = -1, rest = n;
        for (int i = 0; i < n; i++, rest--) {
            int r = (target - sum) / rest; // 剩余后面的都变成多少比较接近
            if (r <= arr[i]) { // 比当前元素小（保证 r > arr[i - 1]，否则上一轮已 break）
                res = r; // 当前及以后都改为 r
                break; // 找到就跳出
            }
            sum += arr[i];
        }

        // 都找不到，说明希望 value 比 arr[n - 1] 还要大，则返回最大即可
        if (res == -1) {
            return arr[n - 1];
        }

        // 当前得出的 res 只保证了总和小于 target 的最近
        // 试一试 res + 1 会不会更近
        int dis = target - sum - res * rest;
        if (Math.abs(target - sum - (res + 1) * rest) < dis) {
            return res + 1;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204},56803 ));
    }
}
