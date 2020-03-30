package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 杨辉三角II {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        if(rowIndex == 0){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prow = res.get(i-1);
            List<Integer> newrow = new ArrayList<>(i);
            newrow.add(1);
            for(int j=1;j<i;j++){
                newrow.add(prow.get(j-1)+prow.get(j));
            }
            newrow.add(1);
            res.add(newrow);
        }
        return res.get(rowIndex);
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
    public static void main(String[] args){
        List<Integer> list = getRow(3);
        list.stream().forEach(System.out::println);
    }
}
