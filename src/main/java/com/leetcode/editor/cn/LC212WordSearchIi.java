package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 212 Word Search II
public class LC212WordSearchIi {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 212);
        Solution solution = new LC212WordSearchIi().new Solution();

    }
    // REVIEW @date 2023-11-29
    // 前缀树
    // 如果能在trie上搜索到叶节点就加入set
    // 修改：在叶节点上存储插入word，从根节点到叶节点的路径

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        private final TrieNode root = new TrieNode();
        private boolean[][] visited = new boolean[12][12];
        private char[][] board;
        private Set<String> set = new HashSet<>(); // 去重

        private void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0, path; i < word.length(); i++) { // 从左往右遍历字符
                path = word.charAt(i) - 'a'; // 由字符，对应成走向哪条路
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
            node.string = word; // 在叶节点上存储插入word，从根节点到叶节点的路径
        }

        private void erase(String word) {
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

        private int countWordsEqualTo(String word) {
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

        private int countWordsStartingWith(String pre) {
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

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            this.board = board;
            for (String w : words) {
                insert(w);
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) { // 从每个位置开始搜索
                    int path = board[i][j] - 'a';
                    if (root.nexts[path] == null) {
                        continue;
                    }
                    visited[i][j] = true;
                    dfs(i, j, root.nexts[path]);
                    visited[i][j] = false;
                }
            }
            return new ArrayList<>(set);
        }

        // 如果当前格子在trie上存在路，就在trie上进行dfs
        private void dfs(int i, int j, TrieNode node) {
            // base case
            if (node.end > 0) {
                set.add(node.string);
            }
            for (var dir : DIRECTIONS) { // 向四个方向搜索匹配下个位置
                int x = i + dir[0], y = j + dir[1]; // 下一个位置(x,y)
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) { // 越界
                    continue;
                }
                if (visited[x][y]) { // 不走回头路
                    continue;
                }
                int path = board[x][y] - 'a';
                if (node.nexts[path] == null) {
                    continue;
                }
                visited[x][y] = true;
                dfs(x, y, node.nexts[path]);
                visited[x][y] = false; // 恢复现场
            }
        }

        private class TrieNode {
            int pass;
            int end;
            String string; // trie的叶节点使用，中间节点不用
            TrieNode[] nexts;

            TrieNode() {
                pass = 0;
                end = 0;
                string = null;
                nexts = new TrieNode[26]; // 0..25 - a..z
            }
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        // 直接用LC79，时间O(M*N*单词数*单词长度) TLE
        private final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        private boolean[][] visited;

        public List<String> findWords(char[][] board, String[] words) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];
            Set<String> set = new HashSet<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) { // 从每个位置开始搜索
                    for (var word : words) {
                        if (set.contains(word)) { // 去重
                            continue;
                        }
                        if (dfs(board, word, i, j, 0)) {
                            set.add(word);
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }

        private boolean dfs(char[][] board, String word, int i, int j, int sIdx) {
            // base case
            if (board[i][j] != word.charAt(sIdx)) {
                return false;
            }
            // 当前位置相同
            if (sIdx == word.length() - 1) { // 搜索到最后一位了
                return true;
            } else if (sIdx >= 10) { // 剪枝，搜索的单词长度不超过10
                return false;
            }
            visited[i][j] = true; // 标记
            boolean ans = false;
            for (var dir : DIRECTIONS) { // 向四个方向搜索匹配下个位置
                int x = i + dir[0], y = j + dir[1]; // 下一个位置(x,y)
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) { // 越界
                    continue;
                }
                if (visited[x][y]) { // 不走回头路
                    continue;
                }
                if (dfs(board, word, x, y, sIdx + 1)) {
                    ans = true;
                    break;
                }
            }
            visited[i][j] = false; // 恢复现场
            return ans;
        }
    }
}