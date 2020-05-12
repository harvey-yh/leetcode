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
}
