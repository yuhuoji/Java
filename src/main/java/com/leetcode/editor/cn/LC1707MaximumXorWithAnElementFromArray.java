package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1707 Maximum XOR With an Element From Array
public class LC1707MaximumXorWithAnElementFromArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1707);
        Solution solution = new LC1707MaximumXorWithAnElementFromArray().new Solution();

        int[] nums = {5, 8, 0, 3, 2, 10, 9, 2, 4, 5};
        int[][] queries = {{3, 8}};
        System.out.println(Arrays.toString(solution.maximizeXor(nums, queries)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // TODO @date 2023-11-19
        //
        public int[] maximizeXor(int[] nums, int[][] queries) {
            Arrays.sort(nums); // 排序
            System.out.println(Arrays.toString(nums));
            int n = queries.length;
            int[] answer = new int[n];
            for (int i = 0; i < n; ++i) {
                int x = queries[i][0], m = queries[i][1];
                // max(nums[j] XOR xi), nums[j] <= m
                int max = -1;
                for (int j = 0; j < n && nums[j] <= m; ++j) {
                    max = Math.max(max, nums[j] ^ x);
                }
                answer[i] = max;
            }
            return answer;
        }

        class Trie {
            public TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                node.pass++;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (node.nexts[path] == null) {
                        node.nexts[path] = new TrieNode();
                    }
                    node = node.nexts[path];
                    node.pass++;
                }
                node.end++;
            }


            public void erase(String word) {
                if (countWordsEqualTo(word) > 0) {
                    TrieNode node = root;
                    node.pass--;
                    for (int i = 0, path; i < word.length(); i++) {
                        path = word.charAt(i) - 'a';
                        if (--node.nexts[path].pass == 0) {
                            node.nexts[path] = null;
                            return;
                        }
                        node = node.nexts[path];
                    }
                    node.end--;
                }
            }

            public int countWordsEqualTo(String word) {
                TrieNode node = root;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.end;
            }

            public int countWordsStartingWith(String pre) {
                TrieNode node = root;
                for (int i = 0, path; i < pre.length(); i++) {
                    path = pre.charAt(i) - 'a';
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.pass;
            }

            class TrieNode {
                public int pass;
                public int end;
                public TrieNode[] nexts;

                public TrieNode() {
                    pass = 0;
                    end = 0;
                    nexts = new TrieNode[26];
                }
            }

        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}