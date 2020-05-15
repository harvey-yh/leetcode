package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/15
 * @slogan Drive business with technology, make business generate value.
 */
public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int left = 0, right = array.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == k){
                int x = mid - 1, y = mid + 1;
                int count = 1;
                while((x >= 0 && array[x] == k) || (y < array.length && array[y] == k)){
                    if(x >= 0 && array[x] == k){
                        x--;
                        count++;
                    }
                    if( y < array.length && array[y] == k){
                        y++;
                        count++;
                    }
                }
                return count;
            }else if(array[mid] < k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        System.out.println(GetNumberOfK(new int[]{3,3,3,3,4,5}, 3));
    }
}
