package 公司.字节跳动.数组与排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //排序(从小到大)
        int len=nums.length;
        if(nums == null || len < 3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            if(nums[i] > 0){
                break;
            }
            //去重
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int x=i+1, y=len-1;
            while(x < y){
                int sum = nums[i] + nums[x] + nums[y];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    //去重
                    while(x<y && nums[x]==nums[x+1]){
                        x++;
                    }
                    while(x<y && nums[y]==nums[y-1]){
                        y--;
                    }
                    x++;
                    y--;
                }else if(sum < 0){
                    x++;
                }else if(sum > 0){
                    y--;
                }
            }
        }
        return result;
    }
}
