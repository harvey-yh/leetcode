package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class Pow {
    public double myPow(double x, int n) {
        if(n==0){
            return 1.00000;
        }

        if(n==1){
            return x;
        }

        if(n==-1){
            return 1.00000/x;
        }

        if(n % 2 == 0){
            double result=myPow(x,n/2);
            return result * result;
        }else{
            double result=myPow(x,n/2);
            if(n>0){
                return result * result * x;
            }else{
                return result * result / x;
            }
        }
    }
}
