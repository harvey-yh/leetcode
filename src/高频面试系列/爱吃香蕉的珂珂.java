package 高频面试系列;

/**
 * @author Harvey
 * @date 2020/7/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 爱吃香蕉的珂珂 {
    /**
     * 二分居然没有遍历快？感觉测试样例的结果都是偏左边界的
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        long sum = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
            sum += pile;
        }
        int l = (int) ((sum - 1) / H) + 1, r = max+1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(canFinish(piles, H, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean canFinish(int[] piles, int H, int speed){
        int time = 0;
        for (int i:piles) {
            time += ((i / speed) + ((i % speed > 0) ? 1 : 0));
        }
        if (time > H) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * ————————————————————————————————————————————————————————
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed1(int[] piles, int H) {
        int maxSpeed = 0, minSpeed = 0;
        long sum = 0;
        for (int n:piles) {
            if (n > maxSpeed) {
                maxSpeed = n;
            }
            sum += n;
        }
        minSpeed = (int) ((sum - 1) / H) + 1;

        for (int i = minSpeed; i < maxSpeed; i++) {
            if (canFinish1(piles, H, i)) {
                return i;
            }
        }
        return maxSpeed;
    }

    boolean canFinish1(int[] piles, int H, int speed) {
        int time = 0;
        for (int i:piles) {
            time += ((i / speed) + ((i % speed > 0) ? 1 : 0));
        }
        if (time > H) {
            return false;
        } else {
            return true;
        }
    }
}
