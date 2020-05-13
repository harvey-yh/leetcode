package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/5/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        if(input == null || k > input.length){
            return res;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;
    }

}
