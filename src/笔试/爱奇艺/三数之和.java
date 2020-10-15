package 笔试.爱奇艺;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 三数之和 {
    /**
     * 三数之和
     *
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[str.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        Arrays.sort(nums);
        List<String> res = threeSum(nums);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> threeSum(int[] nums){
        List<String> res = new ArrayList<>();
        for(int i=0;i<nums.length-2 && nums[i] <= 0;i++){
            while(i >= 1 && i < nums.length-2 && nums[i] == nums[i-1]){
                i++;
            }
            int l = i+1, r = nums.length-1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[i]).append(" ").append(nums[l]).append(" ").append(nums[r]);
                    res.add(sb.toString());
                    while(l+1 < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(l < r-1 && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
