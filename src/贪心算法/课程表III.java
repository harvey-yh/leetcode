package 贪心算法;

import java.util.Arrays;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 课程表III {
    public static int scheduleCourse(int[][] courses) {
        if(courses.length == 1){
            return 1;
        }
        Arrays.sort(courses, (o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);
        int res = 1, l=0, r=1;
        while(r<courses.length){
            if(courses[r][0] >= courses[l][1]){
                res++;
                l=r;
                r++;
            }else{
                r++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(scheduleCourse(new int[][]{ {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }
}
