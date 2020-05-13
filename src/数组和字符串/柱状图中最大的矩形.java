package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/5/13
 * @slogan Drive business with technology, make business generate value.
 */
public class 柱状图中最大的矩形 {
    /**
     * 暴力
     * 空间复杂度O(1)
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int max = heights[0];
        int min = heights[0];
        for(int i=1;i<heights.length;i++){
            int x = i, y = i;
            for(int j = i-1; j >= 0;j--){
                if(heights[j] >= heights[i]){
                    x--;
                }else{
                    break;
                }
            }
            for(int j = i+1; j < heights.length;j++){
                if(heights[j] >= heights[i]){
                    y++;
                }else{
                    break;
                }

            }
            max = Math.max(max, (y-x+1)*heights[i]);
            min = Math.min(min, heights[i]);
            System.out.println((y-x+1)*heights[i]);
        }
        return max > min*heights.length ? max : min*heights.length;
    }

    public static int largestRectangleArea1(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        int max = 0;
        left[0] = -1;
        right[n-1] = n;
        for(int i=1;i<n;i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        for(int i=n-2;i>=0;i--) {
            int z = i + 1;
            while(z < n && heights[z] >= heights[i]){
                z = right[z];
            }
            right[i] = z;
        }
        for(int i=0;i<n;i++){
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(largestRectangleArea1(new int[]{2,0,2}));
    }
}
