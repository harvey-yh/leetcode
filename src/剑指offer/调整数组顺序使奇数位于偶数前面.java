package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void reOrderArray(int [] array) {
        int[] res = new int[array.length];
        int l=0,r=array.length-1;
        int i=0,j=array.length-1;
        while(l<array.length && r>=0){
            if(l<array.length){
                if(array[l] % 2 == 1){
                    res[i] = array[l];
                    i++;
                    l++;
                }else{
                    l++;
                }
            }
            if(r >= 0){
                if(array[r] % 2 == 0){
                    res[j] = array[r];
                    j--;
                    r--;
                }else{
                    r--;
                }
            }
        }
        for(int z=0;z<array.length;z++){
            array[z] = res[z];
        }
    }
    public static void main(String[] args){
        int[] res = new int[]{1,2,3,4,5,6,7};
        reOrderArray(res);
        for(int z=0;z<res.length;z++){
            System.out.println(res[z]);
        }

    }
}
