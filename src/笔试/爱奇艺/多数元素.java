package 笔试.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 多数元素 {
    /**
     * 多数元素
     * 给定一个大小为 n 的整数数组，找到其中的多数元素。多数元素是指在数组中出现次数大于『n/2』的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[str.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(nums);
        System.out.println(nums[nums.length/2]);
    }
}
