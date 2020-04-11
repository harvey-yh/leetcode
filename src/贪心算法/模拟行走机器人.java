package 贪心算法;

import java.util.HashSet;

/**
 * @author Harvey
 * @date 2020/4/4
 * @slogan Drive business with technology, make business generate value.
 */
public class 模拟行走机器人{
    /**
     *题意说明
     *1.障碍物数组是[[x1,y2],[x2,y2],...,[xn,yn],...]这样的结构，其中每个二元组代表一个障碍的x和y坐标
     *2.机器人机器人在前进的过程中遇到障碍会原地踏步，直到转向。
     *3.要求的不是机器人执行完指令序后最终的位置到初始位置的欧式距离，而是整个过程中所达到最大欧式距离。
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
        int x = 0, y = 0, state = 0;
        HashSet<Long> obs = new HashSet<>();
        for(int i = 0; i < obstacles.length; ++i) {
            obs.add((long)((obstacles[i][0] << 16) + obstacles[i][1]));
        }
        int res = 0;
        for(int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case -1:
                    state = (state + 1) % 4;
                    break;
                case -2:
                    state = (state + 3) % 4;
                    break;
                default:
                    for(int j = 0; j < commands[i]; ++j) {
                        int nextX = x + dx[state];
                        int nextY = y + dy[state];
                        if(obs.contains((long)((nextX << 16) + nextY))) {
                            break;
                        }
                        res = Math.max(nextX * nextX + nextY * nextY, res);
                        x = nextX;
                        y = nextY;
                    }
            }
        }
        return res;
    }
}
