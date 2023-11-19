package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 208 Implement Trie (Prefix Tree)
public class LC208ImplementTriePrefixTree {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 208);
        Trie trie = new LC208ImplementTriePrefixTree().new Trie();
        //["Trie","insert","search","search","startsWith","insert","search"]
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        TrieNode root; // 根节点

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++; // 根节点pass+1
            for (int i = 0, path; i < word.length(); ++i) {
                path = word.charAt(i) - 'a'; // 下一个方向
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                node = node.nexts[path];
                node.pass++; // 下一个节点的pass+1
            }
            node.end++; // 最后一个节点end+1
        }

        // 是否在树中
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0, path; i < word.length(); ++i) {
                path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return false;
                }
                node = node.nexts[path];
            }
            return node.end > 0; // end=1
        }

        // 是否有前缀
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0, path; i < prefix.length(); ++i) {
                path = prefix.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return false;
                }
                node = node.nexts[path];
            }
            return node.pass > 0;
        }

        class TrieNode {
            TrieNode[] nexts;
            int pass;
            int end;

            TrieNode() {
                nexts = new TrieNode[26]; // 存26个英文字母
                pass = 0;
                end = 0;
            }
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// leetcode submit region end(Prohibit modification and deletion)
}
