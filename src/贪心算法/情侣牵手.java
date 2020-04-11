package 贪心算法;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 情侣牵手 {
    public static int minSwapsCouples(int[] row) {
        int ans = 0;
        int n = row.length;
        int[] indexArr = new int[n];

        for (int i = 0; i < n; i++) {
            indexArr[row[i]] = i;
        }

        int next;
        for (int i = 0; i < n; i += 2) {
            next = (row[i] & 1) == 0 ? row[i] + 1 : row[i] - 1;
            if (next == row[i + 1]) {
                continue;
            }

            // 其实无需真正执行交换操作，由于进入i + 1位置的人现在已经配对到情侣了，后面不会再用到了，
            // 因此只要更新离开i+1位置的那个人的信息即可
            int swapedIndex = indexArr[next];
            indexArr[row[i+1]] = swapedIndex;
            row[swapedIndex] = row[i + 1];
            ans++;
        }

        return ans;
    }
    public int minSwapsCouples1(int[] row) {
        int ans = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if (row[i+1] == (x ^ 1)) {
                continue;
            }
            ans++;
            for (int j = i+1; j < row.length; ++j) {
                if (row[j] == (x^1)) {
                    row[j] = row[i+1];
                    row[i+1] = x^1;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(minSwapsCouples(new int[]{0,2,4,6,7,1,3,5}));
    }
}
