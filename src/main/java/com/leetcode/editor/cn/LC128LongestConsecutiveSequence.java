package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 128 最长连续序列
public class LC128LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 128);
        Solution solution = new LC128LongestConsecutiveSequence().new Solution();

    }

    // REVIEW @date 2024-07-22 并查集（哈希表，带size）
    // 1.哈希表
    // 2.并查集
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 并查集 最大的集合容量
        private final Map<Integer, Integer> father = new HashMap<>();
        private final Map<Integer, Integer> size = new HashMap<>();

        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            for (int i = 0; i < n; ++i) { // 初始化并查集
                father.put(nums[i], nums[i]);
                size.put(nums[i], 1);
            }
            for (int x : nums) {
                if (father.containsKey(x + 1)) {
                    union(x, x + 1);
                }
            }
            return Collections.max(size.values());
        }

        private int find(int i) {
            if (father.get(i) != i) {
                father.put(i, find(father.get(i)));
            }
            return father.get(i);
        }

        private boolean isSameSet(int i, int j) {
            return find(i) == find(j);
        }

        private void union(int i, int j) {
            int fi = find(i);
            int fj = find(j);
            if (fi != fj) {
                father.put(fi, fj); // fi挂fj
                size.put(fj, size.get(fj) + size.get(fi));
            }
        }
    }

    // 哈希表
    // 012..56..7..9 分段统计，求最长的长度
    class Solution1 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> st = new HashSet<>();
            for (int x : nums) {
                st.add(x);
            }
            int ans = 0;
            for (int x : st) {
                if (st.contains(x - 1)) {
                    continue;
                }
                int curNum = x;
                int curLen = 1;
                while (st.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                ans = Math.max(ans, curLen);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}