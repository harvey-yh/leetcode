package 位运算;

/**
 * @author Harvey
 * @date 2020/7/21
 * @slogan Drive business with technology, make business generate value.
 */
public class 比特位计数 {
    /**
     * 方法一：i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，
     * 而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 方法二：i >> 1会把最低位去掉，因此i >> 1也是比i小的，同样也是在前面的数组里算过。
     * 当i的最低位是0，则i中1的个数和i >> 1中1的个数相同；
     * 当i的最低位是1，则i中1的个数是i >> 1中1的个数再加1；
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for(int i = 0;i<= num;i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
