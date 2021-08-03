package 每日一题;

/**
 * @author yuanhao6
 * @version 1.0
 * @date 2021/8/3 09:19
 */
public class 最短无序连续子数组 {
    public static int findUnsortedSubarray(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int r = 0, l = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max > arr[i]) {
                r = i;
            }
            max = Math.max(max, arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(min < arr[i]) {
                l = i;
            }
            min = Math.min(min, arr[i]);
        }
        return r == l ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{1,2,4,5,3}));
    }
}
