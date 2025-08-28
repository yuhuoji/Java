package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1512 好数对的数目
public class LC1512NumberOfGoodPairs {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "1512");
        Solution solution = new LC1512NumberOfGoodPairs().new Solution();

    }

    // 选择数
    // c(4,2)

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIdenticalPairs(int[] nums) {
            int n = nums.length;
            Map<Integer, Integer> mp = new HashMap<>();
            int ans = 0;
            for (int j = 0; j < n; ++j) {
                int x = nums[j];
                int c = mp.getOrDefault(x, 0);
                ans += c;
                mp.put(x, c + 1);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}