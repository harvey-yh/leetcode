package 牛客题霸;

/**
 * @author Harvey
 * @date 2020/9/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 寻找第K大 {

    public static int findKth(int[] a, int n, int K) {
        return find(a, 0, n-1, K);
    }
    private static int find(int[] a, int low, int high, int K) {
        int pivot = partition(a, low, high);

        if(pivot + 1 < K){
            return find(a, pivot+1, high, K);
        } else if(pivot + 1 > K){
            return find(a, low, pivot-1, K);
        } else{
            return a[pivot];
        }
    }

    //从大到小排序
    private static int partition(int[] a, int low, int high) {
        int tmp = a[low];
        while (low < high) {
            while (low < high && a[high] <= tmp) {
                high--;
            }
            if(low < high){
                a[low++] = a[high];
            }

            while (low < high && a[low] > tmp) {
                low++;
            }
            if(low < high){
                a[high--] = a[low];
            }
        }
        a[low] = tmp;
        return low;
    }

    public static void main(String[] args){
        System.out.println(findKth(new int[]{1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663}, 49, 24));
    }
}
