package 二分查找;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 第一个错误的版本 {

    public int firstBadVersion(int n) {
        int left=1, right=n;
        while(left < right){
            int mid = left+(right-left)/2;
            if(!isBadVersion(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    //题目调用系统给出的isBadVersion方法，这里避免程序显示错误，随便写了一个。
    public boolean isBadVersion(int version){
        return true;
    }
}
