package 数组和字符串;

/**
 * @author Harvey
 * @date 2020/4/2
 * @slogan Drive business with technology, make business generate value.
 */
public class 移动零 {
    public static void moveZeroes(int[] nums) {
        int l=0,r=0;
        if(nums.length==0 || nums.length== 1){
            return;
        }
        while(l<nums.length && nums[l] != 0){
            l++;
        }
        r = l;
        while(l<nums.length && r<nums.length){
            if(nums[r] != 0){
                swap(nums, l, r);
                    l++;
                r++;
            }else{
                r++;
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public void moveZeroes1(int[] nums) {
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if (nums[right]!=0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for (int i = left;i<nums.length;i++){
            nums[i] = 0;
        }
    }




    public static void main(String[] args){
        int[] x = new int[]{2,1};
        moveZeroes(x);
        for(int i : x){
            System.out.println(i);
        }
    }
}
