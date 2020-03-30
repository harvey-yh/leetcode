package 数组和字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 杨辉三角 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prow = res.get(i-1);
            List<Integer> newrow = new ArrayList<>(i);
            newrow.add(1);
            for(int j=1;j<i;j++){
                newrow.add(prow.get(j-1)+prow.get(j));
            }
            newrow.add(1);
            res.add(newrow);
        }
        return res;
    }
    public static void main(String[] args){
        List<List<Integer>> list = generate(5);
        list.stream().forEach(System.out::println);
    }
}
