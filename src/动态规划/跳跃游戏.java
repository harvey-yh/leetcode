package 动态规划;

/**
 * @author Harvey
 * @date 2020/7/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i > max){
                return false;
            }
            max = Math.max(max, i+nums[i]);
        }
        return true;
    }
}
