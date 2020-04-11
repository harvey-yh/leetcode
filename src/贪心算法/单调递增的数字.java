package 贪心算法;


/**
 * @author Harvey
 * @date 2020/4/10
 * @slogan Drive business with technology, make business generate value.
 */
public class 单调递增的数字 {
    public static int monotoneIncreasingDigits(int N) {
        int[] x = new int[20];
        int len = 0;
        while (N > 0){
            x[len ++] = N % 10;
            N /= 10;
        }
        len --;
        int pos = -1;
        for (int i = 0; i < len; i++){
            if (x[i] < x[i+1]){
                pos = i;
                x[i+1] = x[i+1] - 1;
            }
        }

        int ans = 0;
        for (int i = len; i > pos; i --){
            ans = ans * 10 + x[i];
        }
        for (int i = pos; i >= 0; i --){
            ans = ans * 10 + 9;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(monotoneIncreasingDigits(333));
    }
}
