package 数学;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * @author Harvey
 * @date 2020/3/30
 * @slogan Drive business with technology, make business generate value.
 */
public class 圆圈中最后剩下的数字 {

    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int tmp=-1;
        int pointer = m-1;
        while(!list.isEmpty()){
            while(pointer >= list.size()){
                pointer -= list.size();
            }

            tmp = list.get(pointer);
            list.remove(pointer);
            pointer += m-1;
        }
        return tmp;
    }

    public int lastRemaining1(int n, int m) {
        int flag = 0;
        for(int i=2;i <= n;i++){
            flag = (flag + m) % i;
        }
        return flag;
    }


    public static void main(String[] args){
        System.out.println(lastRemaining(5,3));
    }

}
