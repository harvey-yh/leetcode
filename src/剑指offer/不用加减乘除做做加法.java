package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/6
 * @slogan Drive business with technology, make business generate value.
 */
public class 不用加减乘除做做加法 {
    public static int Add(int num1,int num2) {
        int sum, carry;
        while(num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
    public static void main(String[] args){
        System.out.println(Add(5, 17));
    }
}
