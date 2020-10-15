package 笔试.华为.第二次;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/9/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 最长的水沟 {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i >= 1 && nums[i][j] < nums[i-1][j]) {
                    continue;
                }
                if(j >= 1 && nums[i][j] < nums[i][j-1]) {
                    continue;
                }
                if(i+1 < n && nums[i][j] < nums[i+1][j]) {
                    continue;
                }
                if(j+1 < m && nums[i][j] < nums[i][j+1]) {
                    continue;
                }
                max = Math.max(max, dfs(nums, i ,j));
            }
        }
        System.out.println(max);
    }

    public static int dfs(int[][] nums, int i, int j){
        String key = i+"-"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int maxlen = 0;
        if(i >= 1 && nums[i-1][j] < nums[i][j]) {
            maxlen = dfs(nums,i-1,j);
        }
        if(j >= 1 && nums[i][j-1] < nums[i][j]) {
            maxlen = Math.max(maxlen, dfs(nums,i,j-1));
        }
        if(i+1 < nums.length && nums[i+1][j] < nums[i][j]) {
            maxlen = Math.max(maxlen, dfs(nums,i+1,j));
        }
        if(j+1 < nums[0].length && nums[i][j+1] < nums[i][j]) {
            maxlen = Math.max(maxlen, dfs(nums,i,j+1));
        }
        maxlen++;
        map.put(key, maxlen);
        return maxlen;
    }


    /**
     * ------------------------------------------------------------------------------------
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                int tmp = backtrack(nums, i, j, Integer.MAX_VALUE, 0);
                result = tmp > result ? tmp : result;
            }
        }
        System.out.println(result);
    }

    public static int backtrack(int[][] nums, int x, int y, int ori, int result){
        if(x < 0 || x >= nums.length || y < 0 || y >= nums[0].length){
            return result;
        }
        if(nums[x][y] >= ori){
            return result;
        }
        result++;
        return Math.max(Math.max(backtrack(nums, x-1, y, nums[x][y], result), backtrack(nums, x+1, y, nums[x][y], result)),
                        Math.max(backtrack(nums, x, y-1, nums[x][y], result), backtrack(nums, x, y+1, nums[x][y], result)));
    }
}

//2 3
//8 4 1
//6 5 2