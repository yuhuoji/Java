package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2300 Successful Pairs of Spells and Potions
public class LC2300SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2300);
        Solution solution = new LC2300SuccessfulPairsOfSpellsAndPotions().new Solution();
        System.out.println(Math.log10(Integer.MAX_VALUE));
        System.out.println(Math.log10(Integer.MAX_VALUE) / Math.log10(2));
    }
    // REVIEW @date 2024-07-04 二分
    // t >= a/b 转换 t > (a-1)/b

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // n*log(m)
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            int n = spells.length;
            int m = potions.length;
            Arrays.sort(potions); // 排序，用二分
            int[] ans = new int[n];
            for (int i = 0; i < n; ++i) {
                long target = (success - 1) / spells[i]; // 找到大于target
                if (potions[m - 1] <= target) {
                    ans[i] = 0;
                    continue;
                }
                int left = 0, right = m - 1;
                while (left <= right) {
                    int mid = ((right - left) >> 1) + left;
                    if (potions[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                ans[i] = m - left;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}