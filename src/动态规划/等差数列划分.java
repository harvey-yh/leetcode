package 动态规划;

/**
 * @author Harvey
 * @date 2020/4/23
 * @slogan Drive business with technology, make business generate value.
 */
public class 等差数列划分 {
    public static int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length<3){
            return 0;
        }
        int[] dp = new int[A.length];
        dp[0]=0;
        dp[1]=0;
        int sum=0;
        for(int i=2;i<A.length;i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1]+1;
                sum+=dp[i];
            }else{
                dp[i] = 0;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
