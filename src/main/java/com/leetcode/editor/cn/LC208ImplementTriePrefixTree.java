package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

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
        System.out.println(Math.pow(26, 2000));
    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        public final int MAXN = 100_009; // 估算 3*10^4操作*长度2_000
        public int[][] tree;
        public int[] end;
        public int[] pass;
        public int cnt;

        public Trie() {
            tree = new int[MAXN][26]; // 路 : 0..25 a..z
            end = new int[MAXN];
            pass = new int[MAXN];
            cnt = 1;
        }

        public void insert(String word) {
            int cur = 1;
            pass[cur]++;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur]++;
        }

        public boolean search(String word) {
            int cur = 1;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return false;
                }
                cur = tree[cur][path];
            }
            return end[cur] > 0;
        }

        public boolean startsWith(String pre) {
            int cur = 1;
            for (int i = 0, path; i < pre.length(); i++) {
                path = pre.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return false;
                }
                cur = tree[cur][path];
            }
            return pass[cur] > 0;
        }

        public void delete(String word) {
            if (search(word)) {
                int cur = 1;
                for (int i = 0, path; i < word.length(); i++) {
                    path = word.charAt(i) - 'a';
                    if (--pass[tree[cur][path]] == 0) {
                        tree[cur][path] = 0;
                        return;
                    }
                    cur = tree[cur][path];
                }
                end[cur]--;
            }
        }

        public void clear() {
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
                end[i] = 0;
                pass[i] = 0;
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

    class Trie1 {

        TrieNode root; // 根节点

        public Trie1() {
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
}
