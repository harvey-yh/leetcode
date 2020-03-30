package 数组和字符串;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 加一 {
    public static int[] plusOne(int[] digits) {
        int[] newdigits = new int[digits.length+1];
        int carry = 0, i = digits.length-1;
        while(i >= 0){
            int k=0;
            if(i == digits.length-1){
                k=1;
            }
            if(digits[i]+carry+k > 9){
                carry = 1;
                newdigits[i+1] = 0;
            }else{
                newdigits[i+1] = digits[i] + carry + k;
                carry=0;
            }
            i--;
        }
        if(carry == 1){
            newdigits[0] = 1;
        }
        return newdigits[0]==0? Arrays.copyOfRange(newdigits, 1, newdigits.length):newdigits;
    }
    public static void main(String[] args){
        System.out.println(plusOne(new int[]{8})[0]);
    }
}
