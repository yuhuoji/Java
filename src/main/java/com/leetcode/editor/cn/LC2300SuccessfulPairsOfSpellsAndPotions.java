package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2300 Successful Pairs of Spells and Potions
public class LC2300SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2300);
        Solution solution = new LC2300SuccessfulPairsOfSpellsAndPotions().new Solution();

    }
    // REVIEW @date 2023-12-15 二分

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int n = spells.length;
            int m = potions.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; ++i) {
                int target = (int) ((success - 1) / spells[i]); // 找第一个大于target的下标。可以只计算一次乘法
                // if (potions[0] > target) { // 都可以
                //     ans[i] = m;
                //     continue;
                // } else
                if ((long) spells[i] * potions[m - 1] < success) { // 都不行
                    ans[i] = 0;
                    continue;
                }
                // 二分
                int l = 0, r = m - 2; //[1,m-2]
                // 循环不变量 <= [l,r] >
                while (l <= r) { // 区间不为空
                    int mid = ((r - l) >> 1) + l;
                    if (potions[mid] <= target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                // l就是第一个大于target的下标
                ans[i] = m - l;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}