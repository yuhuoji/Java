package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 211 Design Add and Search Words Data Structure
public class LC211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 211);
        WordDictionary wordDictionary = new LC211DesignAddAndSearchWordsDataStructure().new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));// 返回 False
        System.out.println(wordDictionary.search("bad")); // 返回 True
        System.out.println(wordDictionary.search(".ad")); // 返回 True
        System.out.println(wordDictionary.search("b..")); // 返回 True
    }

    // REVIEW @date 2023-11-28 字典胡变形
    // search方法，‘.’
    // 测试用例b..
    // leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        int MAXN = 250000;
        int[][] tree = new int[MAXN][26];
        int[] end = new int[MAXN];
        int[] pass = new int[MAXN];
        int cnt;

        public WordDictionary() {
            cnt = 1;// 1作为根节点
        }

        public void addWord(String word) {
            int cur = 1; // 根节点
            pass[cur]++;
            for (int i = 0, path; i < word.length(); ++i) {
                path = word.charAt(i) - 'a'; // 下一个方向
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path]; // 下一个节点
                pass[cur]++;
            }
            end[cur]++; // 最后一个节点
        }

        //'.'最多两个
        public boolean search(String word) {
            return dfs(word, 0, 1);
        }

        // 从 sIdx 开始
        // 用例b..
        // 递归
        private boolean dfs(String word, int sIdx, int treeIdx) {
            int cur = treeIdx;
            if (sIdx == word.length()) {// 搜索到结尾了
                return end[cur] > 0;
            }
            if (word.charAt(sIdx) == '.') {
                for (int i = 0; i < 26; ++i) { // 所有路，取or
                    if (tree[cur][i] != 0 && dfs(word, sIdx + 1, tree[cur][i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int path = word.charAt(sIdx) - 'a';
                if (tree[cur][path] == 0) { // 下一个节点
                    return false;
                }
                return dfs(word, sIdx + 1, tree[cur][path]);
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// leetcode submit region end(Prohibit modification and deletion)

}