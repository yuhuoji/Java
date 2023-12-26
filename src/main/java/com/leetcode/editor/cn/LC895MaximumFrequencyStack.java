package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 895 Maximum Frequency Stack
public class LC895MaximumFrequencyStack {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 895);
        FreqStack solution = new LC895MaximumFrequencyStack().new FreqStack();

    }

    // 最大频率栈 能返回出现频率最高的元素
    // leetcode submit region begin(Prohibit modification and deletion)
    class FreqStack {
        private int topTimes; // 最大次数
        private Map<Integer, List<Integer>> cntValues; // 每层出现次数相同,每层一个动态数组
        private Map<Integer, Integer> valueTimes; // 词频表，每个数出现几次

        public FreqStack() {
            topTimes = 0;
            cntValues = new HashMap<>();
            valueTimes = new HashMap<>();
        }

        public void push(int val) {
            valueTimes.put(val, valueTimes.getOrDefault(val, 0) + 1);
            int curTimes = valueTimes.get(val); // 当前值的出现次数（高度）
            if (!cntValues.containsKey(curTimes)) { // 当前高度没有动态数组
                cntValues.put(curTimes, new ArrayList<>());
            }
            List<Integer> curTimeValues = cntValues.get(curTimes);
            curTimeValues.add(val);
            topTimes = Math.max(topTimes, curTimes); // 更新最大次数
        }

        // 返回出现频率最高的元素
        public int pop() {
            List<Integer> topTimeValues = cntValues.get(topTimes); // 最高一层
            int ans = topTimeValues.remove(topTimeValues.size() - 1);
            if (topTimeValues.size() == 0) { // 最高层为空
                cntValues.remove(topTimes);
                topTimes--;
            }
            // 当前元素的次数减少1
            int times = valueTimes.get(ans);
            if (times == 1) {
                valueTimes.remove(ans);
            } else {
                valueTimes.put(ans, times - 1);
            }
            return ans;
        }
    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// leetcode submit region end(Prohibit modification and deletion)

}