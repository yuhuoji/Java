package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1052 爱生气的书店老板
public class LC1052GrumpyBookstoreOwner {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1052");
        Solution solution = new LC1052GrumpyBookstoreOwner().new Solution();

    }

    // 滑动窗口 max(ans)=sum-min(不满意的人数)
    // min(不满意的人数)=所有不满意的人数-滑动窗口最大值
    // minutes长度，
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int[] s = new int[2];

        }

        // todo
        public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int sum = Arrays.stream(customers).sum();
            int unsatisfied = 0; // 所有不满意的人数
            int mx = 0; // 滑动窗口最大值
            int cnt = 0; // 滑动窗口当前的值
            for (int i = 0; i < n; ++i) {
                if (grumpy[i] == 1) {
                    unsatisfied += customers[i];
                    cnt += customers[i];
                }
                if (i < minutes - 1) {
                    continue;
                }
                mx = Math.max(mx, cnt);
                if (i >= minutes && grumpy[i - minutes] == 1) {
                    cnt -= customers[i - minutes];
                }
            }
            return sum - (unsatisfied - mx);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}