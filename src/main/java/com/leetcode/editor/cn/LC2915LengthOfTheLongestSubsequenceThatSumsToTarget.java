package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.List;

// 2915 和为目标值的最长子序列的长度
public class LC2915LengthOfTheLongestSubsequenceThatSumsToTarget {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2915);
        Solution solution = new LC2915LengthOfTheLongestSubsequenceThatSumsToTarget().new Solution();

    }

    // 01背包 只能选一次
    // f[i][c] 0..i位置和为c的最长长度
    // f[i][c]=max(f[i-1][c],f[i-1][c-nums[i]]+1)
    // 初始值f[-][0]=0 选完了 f[-][+]=-inf不合理
    // 返回f[n-1][target]
    // f增加一个位置
    // f[i+1][c]=max(f[i][c],f[i][c-nums[i]]+1)
    // 初始值f[0][0]=0 选完了 f[0][+]=-inf不合理
    // 返回f[n][target]
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int n = nums.size();
            int[][] f = new int[n + 1][target + 1];
            Arrays.fill(f[0], Integer.MIN_VALUE);
            f[0][0] = 0;
            for (int i = 0; i < n; ++i) {
                for (int c = 0; c <= target; ++c) {
                    if (c < nums.get(i)) {
                        f[i + 1][c] = f[i][c];
                    } else {
                        f[i + 1][c] = Math.max(f[i][c], f[i][c - nums.get(i)] + 1);
                    }
                }
            }
            int ans = f[n][target];
            return ans > 0 ? ans : -1;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}