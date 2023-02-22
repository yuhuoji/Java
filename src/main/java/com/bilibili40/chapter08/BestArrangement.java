package com.bilibili40.chapter08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @date 2022-11-26 15:20
 * 贪心算法
 * TODO 局部最优 -> ? -> 整体最优
 *
 * ！！！贪心算法的在笔试时的解题套路！！！
 * 1,实现一个不依靠贪心策略的解法X,可以用最暴力的尝试
 * 2,脑补出贪心策略A、贪心策略B、贪心策略C...
 * 3,用解法X和对数器,去验证每一个贪心策略,用实验的方式得知哪个贪心策略正确
 * 4,不要去纠结贪心策略的证明
 *
 * 一些项目要占用一个会议室宣讲,会议室不能同时容纳两个项目的宣讲。给你每一个项目开始的时间和结束的时间(给你一个数组,里面是一个个具体的项目),你来安排宣讲的日程,
 * 要求会议室进行的宣讲的场次最多。返回这个最多的宣讲场次。
 * 策略：结束时间早
 */
public class BestArrangement {
    /**
     * @param programs  所有会议
     * @param timePoint 当前已安排到的时间点
     * @return 安排的会议数量
     */
    public int bestArrangement(Program[] programs, int timePoint) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0; //已经安排的会议数量
        for (int i = 0; i < programs.length; i++) { //按结束时间先后依次遍历所有会议
            if (timePoint <= programs[i].start) { //在当前时间点此会议还没开始 => 可以安排该会议
                result++; //计数+1
                timePoint = programs[i].end; //时间点来到此会议的结束时间继续安排
            }
        }
        return result;
    }

    public static class Program {
        public int start; //会议开始时间
        public int end; //会议结束时间

        public Program() {
        }

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //比较器
    public class ProgramComparator implements Comparator<Program> {
        //贪心策略：优选选择结束时间早的会议
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
