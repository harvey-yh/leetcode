package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/3/31
 * @slogan Drive business with technology, make business generate value.
 */
public class 二进制求和 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int carry = 0;
        int i=aa.length-1, j=bb.length-1;
        while(i >= 0 && j >= 0){
            int x = aa[i] - '0', y = bb[j] - '0';
            int sum = x+y+carry;
            if(sum > 1){
                sb.append(sum%2);
                carry = 1;
            }else{
                sb.append(sum);
                carry = 0;
            }
            i--;
            j--;
        }
        if(i>=0){
            for(int z = i; z >= 0; z--){
                sb.append((aa[z]-'0'+carry)%2);
                carry = carry == 1 ? (aa[z]-'0'+carry)/2: 0;
            }

        }else if(j>=0){
            for(int z = j; z >= 0; z--){
                sb.append((bb[z]-'0'+carry)%2);
                carry = carry == 1 ? (bb[z]-'0'+carry)/2: 0;
            }
        }
        if(carry == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        String a = "101111", b="10";
        System.out.println(addBinary(a,b));
    }
}
