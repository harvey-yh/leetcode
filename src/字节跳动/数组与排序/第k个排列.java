package 字节跳动.数组与排序;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 第k个排列 {
    public static String getPermutation(int n, int k) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            arrayList.add(i);
        }
        StringBuilder result = new StringBuilder();
        k--;
        while(n>0){
            //先求出n-1的阶乘
            int val = 1;
            for(int i=1;i<n;i++){
                val *= i;
            }

            int index = k/val;
            result.append(arrayList.get(index));
            arrayList.remove(index);
            k = k%val;
            n--;
        }
        return result.toString();
    }
}
