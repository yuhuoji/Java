package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 219 存在重复元素 II
public class LC219ContainsDuplicateIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "219");
        Solution solution = new LC219ContainsDuplicateIi().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                int x = nums[i];
                if (mp.containsKey(x) && Math.abs(mp.get(x) - i) <= k) {
                    return true;
                }
                mp.put(x, i);
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}