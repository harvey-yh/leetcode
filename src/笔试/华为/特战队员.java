package 笔试.华为;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/20
 * @slogan Drive business with technology, make business generate value.
 */
public class 特战队员 {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] s = new int[][]{};
        String[] str = sc.nextLine().split(" ");
        if(str.length != 2){
            System.out.println(Arrays.toString(s));
        }else{
            int l=0;
            while(l < str[0].length()){
                if(str[0].charAt(l) < '0' || str[0].charAt(l) > '9'){
                    break;
                }else{
                    l++;
                }
            }
            int r=0;
            while(r < str[1].length()){
                if(str[1].charAt(r) < '0' || str[1].charAt(r) > '9'){
                    break;
                }else{
                    r++;
                }
            }
            if(l != str[0].length() || r != str[1].length()){
                System.out.println(Arrays.toString(s));
            }else{
                int m = Integer.valueOf(str[0]);
                int n = Integer.valueOf(str[1]);
                if(m < 10 || n < 10 || m > 1000 || n > 1000){
                    System.out.println(Arrays.toString(s));
                }else{
                    int[][] ans = func(m,n);
                    System.out.println(Arrays.toString(ans));
                }
            }
        }
    }

    public static int[][] func(int m, int n){
        int i = 0, j = 0;
        int count = 1;
        boolean[][] visited = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        int t = 0;
        int[][] dict = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        while(count <= m * n){
            if(j == n){
                t++;
                j--;
                i++;
                continue;
            }else if(i == m){
                t++;
                i--;
                j--;
                continue;
            }else if(j < 0){
                t++;
                j++;
                i--;
                continue;
            }else if(i < 0){
                t++;
                i++;
                j++;
                continue;
            }
            if(visited[i][j]) {
                t++;
                i += dict[t % 4][0] + dict[(t+1) % 4][0];
                j += dict[t % 4][1] + dict[(t+1) % 4][1];
            }else{
                if(helper(count)){
                    res.add(new int[]{i, j});
                }
                visited[i][j] = true;
                count++;
                i += dict[t % 4][0];
                j += dict[t % 4][1];
                if(i >= 0 && i < m && j>=0 && j<n && visited[i][j]){
                    i -= dict[t % 4][0];
                    j -= dict[t % 4][1];
                    t++;
                    i += dict[t % 4][0];
                    j += dict[t % 4][1];
                }
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int k=0;k<res.size();k++){
            ans[k] = res.get(k);
        }
        return ans;
    }
    public static boolean helper(int target){
        if(target % 10 == 7 && ((target / 10) % 10) % 2 == 1){
            return true;
        }else{
            return false;
        }
    }
}
