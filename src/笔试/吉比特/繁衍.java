package 笔试.吉比特;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 繁衍 {
    /**
     * 1 2 3 1
     * 4 5
     * 6 7
     * 8 9
     * 37 33 22
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int n = sc.nextInt();
        int[][] xy = new int[3][2];
        for(int i=0;i<3;i++){
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }
        long A = x, B = y, C = z;
        while(n-- > 0){
            A = ((A%1000000007 + y * xy[1][0])%1000000007 + (z * xy[2][0])%1000000007)%1000000007;
            B = ((B%1000000007 + x * xy[0][0])%1000000007 + (z * xy[2][1])%1000000007)%1000000007;
            C = ((C%1000000007 + x * xy[0][1])%1000000007 + (y * xy[1][1])%1000000007)%1000000007;
        }
        System.out.println(A%1000000007+" "+B%1000000007+" "+C%1000000007);
    }
}
