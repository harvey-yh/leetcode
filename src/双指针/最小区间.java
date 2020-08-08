package 双指针;

import java.util.*;

/**
 * @author Harvey
 * @date 2020/8/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 最小区间 {
    static class Node{
        int num;
        int index;
        public Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        int min = 0, max = 0;
        int interval = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.num - o2.num) ;
        int rmax = 0;
        for(int i=0;i<nums.size();i++){
            queue.add(new Node(nums.get(i).get(0), i));
            if(rmax < nums.get(i).get(0)){
                rmax = nums.get(i).get(0);
            }
            nums.get(i).remove(0);
        }
        int removeIndex;
        while(true){
            int distance = rmax - queue.peek().num;
            if(interval > distance){
                interval = distance;
                min = queue.peek().num;
                max = rmax;
            }
            removeIndex = queue.poll().index;
            if(!nums.get(removeIndex).isEmpty()){
                nums.get(removeIndex).remove(0);
            }
            if(!nums.get(removeIndex).isEmpty()){
                queue.add(new Node(nums.get(removeIndex).get(0), removeIndex));
                if(rmax < nums.get(removeIndex).get(0)){
                    rmax = nums.get(removeIndex).get(0);
                }
            }else{
                break;
            }
        }
        return new int[]{min, max};
    }


    public int[] smallestRange1(List<List<Integer>> nums) {
        int len=nums.size();
        int[] index=new int[len];
        int max=0, range=Integer.MAX_VALUE;
        int left=0, right=0;
        Queue<Integer> queue = new PriorityQueue<>((n1, n2)->
                nums.get(n1).get(index[n1])-nums.get(n2).get(index[n2]));
        for(int i=0;i<len;i++){
            queue.add(i);
            max = Math.max(max,nums.get(i).get(0));
        }
        while(true){
            int minindex = queue.poll();
            int currange = max-nums.get(minindex).get(index[minindex]);
            if(range > currange){
                range = currange;
                left = nums.get(minindex).get(index[minindex]);
                right = max;
            }
            index[minindex]++;
            if(index[minindex] >= nums.get(minindex).size()) {
                break;
            }
            max=Math.max(max, Math.max(max,nums.get(minindex).get(index[minindex])));
            queue.offer(minindex);
        }
        return new int[]{left, right};
    }
    public static void main(String[] args){
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<Integer> num3 = new ArrayList<>();
        num1.add(4);
        num1.add(10);
        num1.add(15);
        num1.add(24);
        num1.add(26);
        num2.add(0);
        num2.add(9);
        num2.add(12);
        num2.add(20);
        num3.add(5);
        num3.add(18);
        num3.add(22);
        num3.add(30);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        System.out.println(smallestRange(nums));
    }
}





















