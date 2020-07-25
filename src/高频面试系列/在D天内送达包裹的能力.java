package 高频面试系列;

/**
 * @author Harvey
 * @date 2020/7/24
 * @slogan Drive business with technology, make business generate value.
 */
public class 在D天内送达包裹的能力 {
    public int shipWithinDays(int[] weights, int D) {
        int max = 0, sum = 0;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }
        int l = max, r = sum+1;
        while(l < r){
            int mid = l + (r-l)/2;
            if(canTransport(weights, D, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean canTransport(int[] w, int D, int cap){
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
