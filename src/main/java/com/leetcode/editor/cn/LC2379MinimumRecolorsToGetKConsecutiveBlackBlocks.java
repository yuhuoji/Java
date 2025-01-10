package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2379 得到 K 个黑块的最少涂色次数
public class LC2379MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2379");
        Solution solution = new LC2379MinimumRecolorsToGetKConsecutiveBlackBlocks().new Solution();

    }
    // 想要B，计算最大连续B的数量，然后k-max

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int n = blocks.length();
            char[] s = blocks.toCharArray();
            int mx = 0;
            int cnt = 0; // 连续B的数量
            for (int i = 0; i < n; ++i) {
                cnt += s[i] == 'B' ? 1 : 0;
                if (i < k - 1) {
                    continue;
                }
                mx = Math.max(mx, cnt);
                cnt -= s[i - k + 1] == 'B' ? 1 : 0;
            }
            return Math.max(k - mx, 0);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}