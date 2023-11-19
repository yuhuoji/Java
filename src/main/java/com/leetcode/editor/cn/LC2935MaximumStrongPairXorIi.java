package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2935 Maximum Strong Pair XOR II
public class LC2935MaximumStrongPairXorIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2935);
        Solution solution = new LC2935MaximumStrongPairXorIi().new Solution();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.maximumStrongPairXor(nums));
    }
    // REVIEW @date 2023-11-19 最大异或和
    // 前缀树

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 2*x>=y

        // 01 trie 根据前缀分组 + 滑动窗口
        public int maximumStrongPairXor(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            Trie trie = new Trie();
            int l = 0, ans = 0;
            for (int y : nums) {
                trie.insert(y);
                while (nums[l] * 2 < y) {
                    trie.erase(nums[l]);
                    l++;
                }
                ans = Math.max(ans, trie.maxXor(y));
            }
            return ans;
        }

        // 哈希表
        public int maximumStrongPairXor1(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int highBit = 31 - Integer.numberOfLeadingZeros(nums[n - 1]); // 获取最高位

            int ans = 0, mask = 0;
            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = highBit; i >= 0; i--) { // 从最高位开始尝试
                seen.clear();
                mask |= (1 << i); // mask
                int newAns = ans | (1 << i);
                for (int y : nums) {
                    int maskY = y & mask; // 让x低于i位置为0
                    if (seen.containsKey(newAns ^ maskY) && seen.get(newAns ^ maskY) * 2 >= y) {// 如果存在一个数y，使得y ^ x = newAns，那么newAns ^ x = y
                        ans = newAns;
                        break;
                    }
                    seen.put(maskY, y);
                }
            }
            return ans;
        }

        // 01trie
        private class Trie {
            final int HIGH_BIT = 19; // 0..19位
            public TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(int num) {
                TrieNode node = root;
                node.pass++;
                for (int i = HIGH_BIT, path; i >= 0; --i) { // 从高位到低位依次插入
                    path = (num >> i) & 1; // 第i位是0还是1
                    if (node.nexts[path] == null) {
                        node.nexts[path] = new TrieNode();
                    }
                    node = node.nexts[path];
                    node.pass++;
                }
                node.end++;
            }

            public void erase(int num) {
                if (countWordsEqualTo(num) > 0) { // 存在
                    TrieNode node = root;
                    node.pass--;
                    for (int i = HIGH_BIT, path; i >= 0; --i) {
                        path = (num >> i) & 1;
                        if (--node.nexts[path].pass == 0) {
                            node.nexts[path] = null;
                            return;
                        }
                        node = node.nexts[path];
                    }
                    node.end--;
                }
            }

            public int countWordsEqualTo(int num) {
                TrieNode node = root;
                for (int i = HIGH_BIT, path; i >= 0; --i) {
                    path = (num >> i) & 1;
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.end;
            }

            public int countWordsStartingWith(int num) {
                TrieNode node = root;
                for (int i = HIGH_BIT, path; i >= 0; --i) {
                    path = (num >> i) & 1;
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.pass;
            }

            public int maxXor(int num) {
                TrieNode node = root;
                int ans = 0;
                for (int i = HIGH_BIT; i >= 0; --i) {
                    int path = (num >> i) & 1;
                    if (node.nexts[path ^ 1] != null) {
                        ans |= (1 << i);
                        path ^= 1;
                    }
                    node = node.nexts[path];
                }
                return ans;
            }

            class TrieNode {
                public int pass;
                public int end;
                public TrieNode[] nexts;

                public TrieNode() {
                    pass = 0;
                    end = 0;
                    nexts = new TrieNode[2]; // 0左 1右
                }
            }
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}