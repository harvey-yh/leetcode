package 位运算;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/5/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 格雷编码 {
    // https://leetcode-cn.com/problems/gray-code/solution/2jin-zhi-ma-zhuan-bcdma-by-wendi-n/
    List<Integer> res = new ArrayList<>();
    public List<Integer> grayCode(int n) {
        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
