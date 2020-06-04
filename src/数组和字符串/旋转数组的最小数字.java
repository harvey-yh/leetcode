package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (array[m] > array[j]) {
                i = m + 1;
            } else if (array[m] < array[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return array[i];
    }
}
