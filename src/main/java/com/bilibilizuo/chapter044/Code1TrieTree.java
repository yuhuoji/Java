package com.bilibilizuo.chapter044;

import java.util.HashMap;

// 前缀树/字典树
// 动态
// 测试链接 : https://leetcode.cn/problems/implement-trie-ii-prefix-tree/
// REVIEW @date 2023-11-19
public class CodeTrieTree {
    // 数组实现路，存26个英文字母
   private class Trie1 {
        public TrieNode root;

        public Trie1() {
            root = new TrieNode();
        }

        public void insert(String word) {
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
        }

        // 如果之前word插入过前缀树，那么此时删掉一次
        // 如果之前word没有插入过前缀树，那么什么也不做
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

        // 查询前缀树里，word单词出现了几次
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

        // 查询前缀树里，有多少单词以pre做前缀
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
                nexts = new TrieNode[26]; // 0..25 - a..z
            }
        }

    }

    // 哈希表实现路，可以存多种字符
   private class Trie2 {

        private TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0, path; i < word.length(); i++) { // 从左往右遍历字符
                path = word.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    node.nexts.put(path, new TrieNode());
                }
                node = node.nexts.get(path);
                node.pass++;
            }
            node.end++;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) > 0) {
                TrieNode node = root;
                TrieNode next;
                node.pass--;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i);
                    next = node.nexts.get(path);
                    if (--next.pass == 0) {
                        node.nexts.remove(path);
                        return;
                    }
                    node = next;
                }
                node.end--;
            }
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    return 0;
                }
                node = node.nexts.get(path);
            }
            return node.end;
        }

        public int countWordsStartingWith(String pre) {
            TrieNode node = root;
            for (int i = 0, path; i < pre.length(); i++) {
                path = pre.charAt(i);
                if (!node.nexts.containsKey(path)) {
                    return 0;
                }
                node = node.nexts.get(path);
            }
            return node.pass;
        }

        class TrieNode {
            public int pass;
            public int end;
            HashMap<Integer, TrieNode> nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new HashMap<>();
            }
        }

    }
}
