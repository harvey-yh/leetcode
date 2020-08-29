package 笔试.科大讯飞;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/29
 * @slogan Drive business with technology, make business generate value.
 */
public class 排序 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = sc.next().trim().split(",");
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.valueOf(strs[i]);
        }
        insertSort(nums);
        System.out.print(nums[0]);
        for(int i=1;i<n;i++){
            System.out.print(","+nums[i]);
        }
    }

    public static void insertSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int max = nums[i], index = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] < max){
                    max = nums[j];
                    index = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }
}
