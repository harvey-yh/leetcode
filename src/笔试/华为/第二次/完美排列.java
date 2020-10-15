package 笔试.华为.第二次;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/9/9
 * @slogan Drive business with technology, make business generate value.
 */
public class 完美排列 {
    /**
     * 转为字符串
     */
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        StringBuilder perform = new StringBuilder();
        StringBuilder value = new StringBuilder();
        for(int i=0;i<k;i++){
            perform.append(sc.nextInt());
        }
        for(int i=0;i<k;i++){
            value.append(sc.nextInt());
        }
        int n = sc.nextInt();
        StringBuilder perform1 = new StringBuilder();
        StringBuilder value1 = new StringBuilder();
        for(int i=0;i<n;i++){
            perform1.append(sc.nextInt());
        }
        for(int i=0;i<n;i++){
            value1.append(sc.nextInt());
        }

        boolean flag = false;
        String p = perform.toString();
        String v = value.toString();
        for(int i=0;i<n;i++){
            if(p.equals(perform1.substring(i,i+k)) && v.equals(value1.substring(i,i+k))){
                System.out.println(i+1);
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(0);
        }
    }


    /**
     * ——————————————————————————————————————————————————————————
     * 利用队列保存所有第一个数与完美序列的第一个数匹配的位置
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prefectPerform = new int [n];
        int[] prefectValue = new int [n];
        for(int i =0;i<n;i++) {
            prefectPerform[i] = sc.nextInt();
            prefectValue[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] perform = new int[m];
        int[] value = new int[m];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            perform[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        for(int i=0;i<m-n;i++){
            if(perform[i] == prefectPerform[0] && value[i] == prefectValue[0]){
                queue.add(i);
            }
        }
        int result = 0;
        while(!queue.isEmpty()){
            int position = queue.poll();
            result = position+1;
            boolean flag = false;
            int index = 0;
            for(int i = position;i<m;i++){
                if(index == n){
                    flag = true;
                    break;
                }else if(perform[i] == prefectPerform[index] && value[i] == prefectValue[index]){
                    index++;
                }else{
                    result = 0;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(result);
    }
}
//3
//1 2 3
//3 2 1
//6
//1 2 3 3 2 1
//3 2 1 1 2 3