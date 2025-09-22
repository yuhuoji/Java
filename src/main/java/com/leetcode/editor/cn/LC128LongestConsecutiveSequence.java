package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 128 最长连续序列
public class LC128LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 128);
        Solution solution = new LC128LongestConsecutiveSequence().new Solution();

    }

    // REVIEW @date 2025-09-22 其他并查集题目 并查集模版

    // 并查集（哈希表实现，带size）
    // 1.哈希表
    // 2.并查集
    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution3 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> st = new HashSet<>();
            for (int x : nums) {
                st.add(x);
            }
            int ans = 0;
            for (int x : st) {
                if (st.contains(x - 1)) { // 只从每一段的第一个数开始
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

    // 练习
    class Solution {
        private Map<Integer, Integer> father = new HashMap<>();
        private Map<Integer, Integer> size = new HashMap<>();

        // 找到根
        private int find(int i) {
            if (father.get(i) != i) {
                father.put(i, find(father.get(i))); // 路经压缩
            }
            return father.get(i);
        }

        private boolean isSameSet(int x, int j) {
            return find(x) == find(j);
        }

        private void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            if (faX != faY) {
                if (size.get(faX) < size.get(faY)) {
                    father.put(faX, faY);
                    size.put(faY, size.get(faX) + size.get(faY));
                } else {
                    father.put(faY, faX);
                    size.put(faX, size.get(faX) + size.get(faY));
                }
            }
        }

        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            for (int x : nums) {
                father.put(x, x);
                size.put(x, 1);
            }
            for (int x : nums) {
                if (father.containsKey(x + 1)) {
                    union(x, x + 1);
                }
            }
            return Collections.max(size.values());
        }
    }

    // 并查集
    class Solution2 {
        private final Map<Integer, Integer> father = new HashMap<>();
        private final Map<Integer, Integer> size = new HashMap<>();

        // 路径优化
        private int find(int i) {
            if (i != father.get(i)) {
                father.put(i, find(father.get(i)));
            }
            return father.get(i);
        }

        private boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        // 路径优化 小挂大
        private void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                if (size.get(fx) < size.get(fy)) {
                    father.put(fx, fy);
                    size.put(fy, size.get(fx) + size.get(fy));
                } else {
                    father.put(fy, fx);
                    size.put(fx, size.get(fx) + size.get(fy));
                }
            }
        }

        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            // 初始化
            for (int x : nums) {
                father.put(x, x);
                size.put(x, 1);
            }
            // union
            for (int x : nums) {
                if (father.containsKey(x + 1)) {
                    union(x, x + 1);
                }
            }
            return Collections.max(size.values());
        }
    }

    // 哈希表 012..56..7..9 分段统计，求最长的长度

    class Solution0 {
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


// leetcode submit region end(Prohibit modification and deletion)

}