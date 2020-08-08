package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/8/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            return addStrings(num2, num1);
        }
        int m = num1.length(), n = num2.length();
        int i=m-1, j=n-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(j >= 0){
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int sum = a+b+carry;
            sb.append(sum%10);
            carry = sum / 10;
            i--;
            j--;
        }
        while(i >= 0){
            int a = num1.charAt(i) - '0';
            int sum = a+carry;
            sb.append(sum%10);
            carry = sum / 10;
            i--;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
