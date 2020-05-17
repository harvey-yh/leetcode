package 周赛;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Harvey
 * @date 2020/4/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 四月二十六周赛 {
    /**
     * 分割字符串的最大得分
     * @param s
     * @return
     */
    public static int maxScore(String s) {
        char[] chs = s.toCharArray();
        int one=0;
        for(char ch : chs){
            if(ch == '1'){
                one++;
            }
        }
        int max = -1, zero1 = 0;
        for (int i=0;i<chs.length-1;i++) {
            if (chs[i] == '0') {
                zero1++;
                max = Math.max(zero1 + one, max);
            } else {
                one--;
                max = Math.max(zero1 + one, max);
            }
        }
        return max;
    }

    /**
     * 可获得的最大点数
     * @param cardPoints [1,2,3,4,5,6,1]
     * @param k 3
     * @return max
     */
    public static int maxScore(int[] cardPoints, int k) {
        if(k==0 || cardPoints == null || cardPoints.length == 0){
            return 0;
        }
        int sum=0,max=0,len=cardPoints.length;
        for(int i=0;i<k;i++) {
            sum+=cardPoints[i];
        }
        max=Math.max(max,sum);
        for(int i=0;i<k;++i){
            sum-=cardPoints[k-i-1];
            sum+=cardPoints[len-i-1];
            max=Math.max(max,sum);
        }
        return max;
    }

    /**
     * 对角线遍历 II
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int n = 0;
        for(int i=nums.size()-1; i>=0; i--){
            List<Integer> curList = nums.get(i);
            for(int j=0; j<curList.size(); j++){
                int val = i + j;
                if(!map.containsKey(val)){
                    List<Integer> list = new ArrayList<>();
                    list.add(curList.get(j));
                    map.put(val, list);
                }else{
                    map.get(val).add(curList.get(j));
                }
                n++;
            }
        }

        int[] res = new int[n];
        int m = 0;
        for (int key : map.keySet()) {
            for(int i=0; i<map.get(key).size(); i++){
                res[m++] = map.get(key).get(i);
            }
        }
        return res;
    }

    /**
     * 带限制的子序列和
     * @param nums
     * @param k
     * @return
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args){
        System.out.println(maxScore(new int[]{9,7,7,9,7,7,9}, 7));
    }
}
