package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 猜数字大小{
    public int guessNumber(int n) {
        int l=1, r=n;
        while(l <= r){
            int m = (r+l)>>>1;
            if(guess(m) == -1){
                r = m-1;
            }else if(guess(m) == 1){
                l = m+1;
            }else{
                return m;
            }
        }
        return -1;
    }
    //题目调用系统给出的guess方法，这里避免程序显示错误，随便写了一个。
    public int guess(int m){
        return -1;
    }
}
