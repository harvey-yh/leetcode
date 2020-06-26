package 双指针;

/**
 * @author Harvey
 * @date 2020/6/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 盛最多水的容器 {
    public static int maxArea(int[] height) {
        int max = 0;
        if(height == null || height.length == 0){
            return 0;
        }
        int i = 0, j = height.length-1;
        while(i < j){
            max = Math.max(max, Math.min(height[i], height[j]) * (j-i));
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
