package 笔试.广联达;

import java.util.Scanner;

/**
 * @author Harvey
 * @date 2020/8/26
 * @slogan Drive business with technology, make business generate value.
 */
public class 魔法书 {
    /**
     * 《XX魔法书》中记载，只有魔法师体内地火水风四种元素平衡的时候才是绝对安全的。某魔法师在给自己做了一个体检，
     * 发现自己体内的四种元素数量分别是A，B，C，D，魔法师慌了，这时他看到魔法书中记载了一种转换魔法，
     * 可以把任意两个单位的元素转换成任意一种元素。
     * 请问魔法师是否可以通过这种魔法，在保证自己体内的元素总量尽可能多的情况下，使得自己体内的四种元素数量完全相同？
     * 如果可以，请输出平衡后体内元素总量，如果不能请输出-1。
     *  1 2 2 4
     *  8
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long[] nums = new long[4];
        long sum = 0;
        for(int i=0;i<4;i++){
            nums[i] = sc.nextLong();
            sum += nums[i];
        }
        long min = sum / 4;
        for(long i=min;i>=0;i--){
            long more = sum - (4 * i);
            int less = 0;
            for(int j=0;j<4;j++){
                if (i - nums[j] > 0){
                    less += i - nums[j];
                }
            }
            if (more >= less) {
                System.out.println(i * 4);
                break;
            }
        }
    }
}
