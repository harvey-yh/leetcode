package 字节跳动.数组与排序;

import java.util.Stack;

/**
 * @author Harvey
 * @date 2020/3/27
 * @slogan Drive business with technology, make business generate value.
 */
public class 接雨水 {
    public int trap(int[] height) {
        int sum = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current);
            current++;
        }
        return sum;
    }

    public int trap1(int[] height) {
        if(height.length<=1) {
            return 0;
        }
        int ans = 0, left=0, right=height.length-1;
        int l_max=0, r_max=0;
        while(left<=right){
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);
            if(l_max < r_max){
                ans+=l_max-height[left];
                left++;
            }else{
                ans+=r_max-height[right];
                right--;
            }
        }
        return ans;
    }

    /**
     * 耗时最短
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if(height.length<=1) {
            return 0;
        }
        int res=0, left=0, right=height.length-1;
        int lmax=height[left], rmax=height[right];
        //假设成山状态，中间最大值，
        while(left<right){
            if(height[left]<height[right]){
                //左半区，水量=左边局部最大-当前深度
                if(height[left]>=lmax) {
                    lmax=height[left];
                } else {
                    res+=lmax-height[left];
                }
                left++;
            }else{
                //右半区同理
                if(height[right]>=rmax) {
                    rmax=height[right];
                } else {
                    res+=rmax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
