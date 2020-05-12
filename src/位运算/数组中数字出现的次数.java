package 位运算;

import 公司.字节跳动.链表与树.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Harvey
 * @date 2020/4/28
 * @slogan Drive business with technology, make business generate value.
 */
public class 数组中数字出现的次数 {
    /**
     * 交换律 a^b = b^a
     * 结合律(a^b)^c == a^(b^c)
     * 对于任何数x，都有x^x=0，x^0=x
     * 自反性 A XOR B XOR B = A xor 0 = A ---> A XOR B = C 则 C XOR B = A
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum ^= num;
        }
        int res = 0;
        int flag = sum &(-sum);
        for(int num:nums){
            if((num & flag) != 0){
                res^=num;
            }
        }
        return new int[]{res, sum^res};
    }
    public int[] singleNumbers2(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum ^= num;
        }
        int h = 1, a=0,b=0;
        while((h & sum) == 0){
            h<<=1;
        }
        for(int num:nums){
            if((num & h) == 0){
                a^=num;
            }else{
                b^=num;
            }
        }
        return new int[]{a,b};
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode p = listNode;
        while(p!=null){
            res.add(p.val);
            p = p.next;
        }
        Collections.reverse(res);
        return res;
    }
}
