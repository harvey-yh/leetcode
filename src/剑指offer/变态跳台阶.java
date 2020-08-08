package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 变态跳台阶 {
    public static int JumpFloorII(int target) {
        if(target==0) {
            return 0;
        }
        if(target==1) {
            return 1;
        }
        if(target==2) {
            return 2;
        }
        int[] dp = new int[target+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=target;i++){
            for(int j=i-1;j>=0;j--){
                dp[i] += dp[j];
            }
            dp[i]++;
        }
        return dp[target];
    }
    public static void main(String[] args){
        System.out.println(JumpFloorII(3));
        Integer.bitCount(1);
    }
}
