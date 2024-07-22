package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1 两数之和
public class LC1TwoSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1);
        Solution solution = new LC1TwoSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                int x = nums[j];
                if (mp.containsKey(target - x)) {
                    return new int[]{mp.get(target - x), j};
                }
                mp.put(x, j);
            }
            return null;
        }

        public int[] twoSum1(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                // int t = target - nums[i];
                // if (t < nums[i + 1] || t > nums[n - 1]) {
                //     break;
                // }
                for (int j = i + 1; j < n; ++j) {
                    if (target == nums[i] + nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}