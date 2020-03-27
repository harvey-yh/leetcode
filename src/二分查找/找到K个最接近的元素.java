package 二分查找;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 找到K个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left=0, right=arr.length-1;
        int middle = left + (right - left) / 2;
        List<Integer> res = new ArrayList<>();
        while(left<=right){
            if(x < arr[middle]){
                right = middle-1;
            }else if(x > arr[middle]){
                left = middle+1;
            }else{
                break;
            }
            middle = left + (right - left) / 2;
        }
        if(arr[middle] != x){
            if(arr[middle] > x && middle-1>=0){
                middle = arr[middle] - x >= x - arr[middle-1] ? middle-1:middle;
            }else if((arr[middle] < x && middle+1<=arr.length-1)){
                middle = x - arr[middle] <= arr[middle+1] - x ? middle:middle+1;
            }
        }
        res.add(arr[middle]);
        int l=1,r=1;
        int flag = -1;
        for (int i = 0; i < k-1; i++) {
            if(flag == 0){ //左边索引已经到头了，无法再取数据
                res.add(arr[middle+r]);
                r++;
                continue;
            }else if(flag ==1){ //右边索引已经到头了，无法再取数据
                res.add(arr[middle-l]);
                l++;
                continue;
            }
            if(middle-l<0){
                i--;
                flag=0;
                continue;
            }else if(middle+r>arr.length-1){
                i--;
                flag=1;
                continue;
            }
            if(x-arr[middle-l] <= arr[middle+r] - x){
                res.add(arr[middle-l]);
                l++;
            }else{
                res.add(arr[middle+r]);
                r++;
            }
        }
        Collections.sort(res);
        return res;
    }
}
