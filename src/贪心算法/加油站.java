package 贪心算法;

/**
 * @author Harvey
 * @date 2020/4/3
 * @slogan Drive business with technology, make business generate value.
 */
public class 加油站 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int p1=0, p2=0, n=gas.length;
        int sum = 0, len = 0, max = 0;
        while(max < n){
            max++;
            if(gas[p1] >= cost[p2]){
                int q1=p1,q2=p2;
                while(sum >= 0 && len < n){
                    sum += gas[q1%n];
                    sum -= cost[q2%n];
                    len++;
                    q1++;
                    q2++;
                }
                if(sum < 0){
                    len--;
                }
                if(len == n){
                    return p1;
                }else{
                    p1++;
                    p2++;
                    sum=0;
                    len=0;
                    continue;
                }
            }else{
                p1++;
                p2++;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int total = 0;
        int index = -1;
        for(int i = 0;i < cost.length; ++i){
            curSum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(curSum < 0){
                index = i;
                curSum = 0;
            }
        }
        return total >=0 ? index+1:-1;
    }

    public static void main(String[] args){
        int[] gas = new int[]{3,3,4};
        int[] cost = new int[]{3,4,4};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
