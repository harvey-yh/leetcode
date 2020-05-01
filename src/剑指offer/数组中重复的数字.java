package 剑指offer;

import java.util.BitSet;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 数组中重复的数字 {
    /**
     * 修改数组的方式
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length < 2){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<0||numbers[i]>numbers.length-1){
                return false;
            }
        }
        for(int i=0;i<length;i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }

    /**
     * 不修改数组情况下
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length < 2){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<0||numbers[i]>numbers.length-1){
                return false;
            }
        }
        BitSet set = new BitSet(length);
        set.clear();
        for(int i=0;i<length;i++){
            if(!set.get(numbers[i])){
                set.set(numbers[i], true);
            }else{
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(duplicate1(new int[]{2,1,3,1,4}, 5, new int[1]));
    }
}
