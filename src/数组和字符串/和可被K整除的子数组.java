package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        if(A == null ||A.length == 0){
            return 0;
        }
        int[] map = new int[K];
        ++map[0];
        int prefixSum = 0, res = 0;
        for(int a : A){
            prefixSum = (a + prefixSum) % K;
            if(prefixSum <0){
                prefixSum += K;
            }
            res += map[prefixSum]++;
        }
        return res;
    }
}
