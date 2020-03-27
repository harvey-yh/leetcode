package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if(num < 2){
            return true;
        }
        long l=2,r=num/2;
        while(l<=r){
            long m = l+(r-l)/2;
            long sum = m*m;
            if(sum == num){
                return true;
            }
            if(sum < num){
                l = m+1;
            }else if(sum > num){
                r = m-1;
            }
        }
        return false;
    }
}
