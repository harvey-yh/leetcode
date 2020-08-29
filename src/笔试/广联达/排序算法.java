package 笔试.广联达;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 排序算法 {
    /**
     * 有一种排序算法定义如下，该排序算法每次只能把一个元素提到序列的开头，例如2，1，3，4，只需要一次操作把1提到序列起始位置就可以使得原序列从小到大有序。
     *
     * 现在给你个乱序的1-n的排列，请你计算最少需要多少次操作才可以使得原序列从小到大有序。
     * @param args
     */
    public static void main(String[] args){
        //输入第一行包含一个正整数n ，表示序列的长度。(1<=n<=100000)
        //接下来一行有n个正整数，表示序列中的n个元素，中间用空格隔开。(1<=a_i<=n)
        //4
        //3 2 1 4
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int[] nums1 = new int[n];
        System.arraycopy(nums, 0, nums1, 0, n);
        Arrays.sort(nums1);
        int i = n - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums[i] == nums1[j]) {
                i--;
                j--;
            } else {
                while (i >= 0 && nums[i] != nums1[j]) {
                    i--;
                }
            }
        }
        System.out.println(j+1);
    }
}
