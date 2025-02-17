package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1052 爱生气的书店老板
public class LC1052GrumpyBookstoreOwner {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1052");
        Solution solution = new LC1052GrumpyBookstoreOwner().new Solution();
        String s1 = "[2,6,6,9]";
        String s2 = "[0,0,1,1]";
        int minutes = 1;
        System.out.println(solution.maxSatisfied(LeetCodeHelper.stringToIntegerArray(s1), LeetCodeHelper.stringToIntegerArray(s2), minutes));
    }

    // REVIEW @date 2025-02-14
    // 滑动窗口 max(ans)=sum-min(不满意的人数)
    // min(不满意的人数)=所有不满意的人数-滑动窗口最大值
    // minutes长度，
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int[] s = new int[2]; // s[0]记录不生气时的顾客数量，s[1]记录宽度是minutes的滑动窗口中生气时的顾客数
            int maxS1 = 0; // 滑动窗口最大值
            int n = customers.length;
            for (int i = 0; i < n; ++i) {
                s[grumpy[i]] += customers[i];
                if (i < minutes - 1) {
                    continue;
                }
                maxS1 = Math.max(maxS1, s[1]);
                s[1] -= grumpy[i - minutes + 1] == 1 ? customers[i - minutes + 1] : 0; // i-minutes+1离开窗口
            }
            return s[0] + maxS1;
        }

        public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int sum = Arrays.stream(customers).sum();
            int unsatisfied = 0; // 所有不满意的人数
            int mx = 0; // 滑动窗口最大值
            int cnt = 0; // 滑动窗口当前值
            for (int i = 0; i < n; ++i) {
                if (grumpy[i] == 1) {
                    unsatisfied += customers[i];
                    cnt += customers[i];
                }
                if (i < minutes - 1) {
                    continue;
                }
                mx = Math.max(mx, cnt);
                if (i - minutes + 1 >= 0 && grumpy[i - minutes + 1] == 1) {
                    cnt -= customers[i - minutes + 1]; //*删去滑动窗口内左侧第一位
                }
            }
            return sum - (unsatisfied - mx);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}