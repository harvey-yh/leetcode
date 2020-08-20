package 公司.字节跳动.挑战字符串;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
class 字符串相乘 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i + j;
                int sum = mul + res[p1+1];
                res[p1+1] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int p:res){
            if(sb.length()==0&&p==0){
                continue;
            }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply1(String num1, String num2) {
        if(num1.length() < num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length() + 2];
        int t = num1.length() + num2.length() + 1;
        int j = num2.length()-1;
        int carry = 0;
        while(j >= 0){
            for(int i=num1.length()-1;i>=0;i--){
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[t] + carry;
                res[t] = sum % 10;
                carry = sum / 10;
                t--;
            }
            if(carry != 0){
                res[t] = carry;
            }
            carry = 0;
            t = num1.length() + 1 + j;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i < res.length && res[i] == 0){
            i++;
        }
        for(j = i;j<res.length;j++){
            sb.append(res[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(multiply1("0","0"));
    }
}
