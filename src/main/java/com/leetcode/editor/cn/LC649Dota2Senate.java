package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Queue;

// 649 Dota2 参议院
public class LC649Dota2Senate {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 649);
        Solution solution = new LC649Dota2Senate().new Solution();

    }

    // 贪心，禁止最早的对手
    // 队列
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
            int n = senate.length();
            char[] s = senate.toCharArray();
            Queue<Integer> r = new ArrayDeque<>();
            Queue<Integer> d = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                if (s[i] == 'R') {
                    r.offer(i);
                } else {
                    d.offer(i);
                }
            }

            while (!r.isEmpty() && !d.isEmpty()) {
                if (r.peek() < d.peek()) {
                    r.offer(r.poll() + n); //!加上n保证只参与下一轮
                    d.poll();
                } else {
                    r.poll();
                    d.offer(d.poll() + n);
                }
            }
            return d.isEmpty() ? "Radiant" : "Dire";
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}