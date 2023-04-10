package com.bilibili40.chapter16;

/**
 * @date 2023-04-10
 * 跳马问题
 * 动态规划
 */
public class HouseJump {

    /**
     * 从(0,0)前往(x,y), 必须跳step步
     *
     * @param x    横坐标
     * @param y    纵坐标
     * @param step 需要跳的步数
     * @return 返回方法数
     */
    private static int process(int x, int y, int step) {
        if (x < 0 || x > 9 || y < 0 || y >= 9) { //越界
            return 0;
        }
        if (step == 0) { //要求跳0步到(0,0)
            return (x == 0 && y == 0) ? 1 : 0;
        }

        //(x,y)不越界且还有步数可以跳
        //有八个可能的位置
        //x - 2,y + 1
        //x - 1,y + 2
        //x + 1,y + 2
        //x + 2,y + 1
        //x + 2,y - 1
        //x + 1,y - 2
        //x - 1,y - 2
        //x - 2,y - 1
        return process(x - 2, y + 1, step - 1) +
                process(x - 1, y + 2, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1);
    }

    public int getWays(int x, int y,int k){
        return process(x,y,k);
    }
}
