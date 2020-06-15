package 周赛;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/6/14
 * @slogan Drive business with technology, make business generate value.
 */
public class 六月十三双周赛 {
    /**
     * 5420. 商品折扣后的最终价格
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        if(prices == null ||prices.length == 0){
            return new int[0];
        }
        int[] res = new int[prices.length];
        System.arraycopy(prices,0,res, 0, prices.length);
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] <= prices[i]){
                    res[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 5422. 子矩形查询
     */
    class SubrectangleQueries{
        int[][] obj ;
        public SubrectangleQueries(int[][] rectangle) {
            this.obj = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++){
                    obj[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            if(row >= 0 && row <obj.length && col >= 0 && col < obj[0].length){
                return obj[row][col];
            }else{
                return -1;
            }
        }
    }

    /**
     * 5423. 找两个和为目标值且不重叠的子数组
     * @param arr
     * @param target
     * @return
     */
    public static int minSumOfLengths(int[] arr, int target) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0, sum  = 0;
        while(j < arr.length){
            if(sum + arr[j] == target){
                res.add(new int[]{i,j});
                sum = sum - arr[i] + arr[j];
                i++;
                j++;
            }else if(sum + arr[j] < target){
                sum += arr[j];
                j++;
            }else{
                sum -= arr[i];
                i++;
            }
        }
        Collections.sort(res, (o1, o2) -> o1[1]-o1[0] - (o2[1]-o2[0]));
        for(i = 0;i < res.size(); i++){
            for(j = i+1;j < res.size(); j++){
                if(res.get(i)[1] < res.get(j)[0] || res.get(i)[0] > res.get(j)[1]){
                    return res.get(i)[1] - res.get(i)[0] + res.get(j)[1] - res.get(j)[0] + 2;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(minSumOfLengths(new int[]{78,18,1,94,1,1,1,29,58,3,4,1,2,56,17,19,4,1,63,2,16,11,1,1,2,1,25,62,10,69,12,7,1,6,2,92,4,1,61,7,26,1,1,1,67,26,2,2,70,25,2,68,13,4,11,1,34,14,7,37,4,1,12,51,25,2,4,3,56,21,7,8,5,93,1,1,2,55,14,25,1,1,1,89,6,1,1,24,22,50,1,28,9,51,9,88,1,7,1,30,32,18,12,3,2,18,10,4,11,43,6,5,93,2,2,68,18,11,47,33,17,27,56,13,1,2,29,1,17,1,10,15,18,3,1,86,7,4,16,45,3,29,2,1,1,31,19,18,16,12,1,56,4,35,1,1,36,59,1,1,16,58,18,4,1,43,31,15,6,1,1,6,49,27,12,1,2,80,14,2,1,21,32,18,15,11,59,10,1,14,3,3,7,15,4,55,4,1,12,4,1,1,53,37,2,5,72,3,6,10,3,3,83,8,1,5}, 97));
    }
}
