package 笔试.字节;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 生产调度 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        // 可以用二分法找
        for(int i=0;i<n;i++){
            int l=0, r=n-1;
            while(l < r){
                int mid = l+(r-l)/2;
                if(a[i] == b[mid]){
                    if(b[l] == b[mid]){
                        break;
                    }
                    l++;
                }else if(a[i] > b[mid]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            count[i] = l+1;
//            for(int j=0;j<n;j++){
//                if(a[i] >= b[j]){
//                    count[i]++;
//                }else{
//                    break;
//                }
//            }
        }
        long sum = 1;
        int s = 0;
        for(int i=0;i<n;i++){
            sum = sum * (count[i] - s) % p;
            s++;
        }
        System.out.println(sum % p);
    }
}
