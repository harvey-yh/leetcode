package 剑指offer;

import java.util.LinkedList;

/**
 * @author Harvey
 * @date 2020/5/7
 * @slogan Drive business with technology, make business generate value.
 */
public class 栈的压入和弹出序列 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if((pushA == null && popA == null) || (pushA.length == 0 && popA.length == 0)){
            return true;
        }
        if(pushA.length != popA.length){
            return false;
        }
        int index1 = 0, index2 = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.push(pushA[index1]);
        index1++;
        while(index1 < pushA.length && index2 < popA.length){
            if(index1 == pushA.length && list.size() == 0){
                break;
            }
            if(list.peek() == popA[index2]){
                list.pop();
                index2++;
            }else{
                list.push(pushA[index1]);
                index1++;
            }
        }
        while(index2 < popA.length){
            if(list.peek() == popA[index2]){
                list.pop();
                index2++;
            }else{
                break;
            }
        }
        return index1 == index2 ? true : false;
    }
    public static void main(String[] args){
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
