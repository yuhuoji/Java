package com.leetcode.editor.cn;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

// 1268 Search Suggestions System
public class LC1268SearchSuggestionsSystem {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1268);
        Solution solution = new LC1268SearchSuggestionsSystem().new Solution();
        String s = "[mobile,mouse,moneypot,monitor,mousepad]";
        //[["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
        String searchWord = "mouse";
        System.out.println(solution.suggestedProducts(LeetCodeHelper.stringToStringArray(s), searchWord));
    }

    // REVIEW @date 2023-12-15 字典树
    // TODO @date 2023-12-15 bug
// 排序+二分
    // leetcode submit region begin(Prohibit modification and deletion)
    // 字典树+优先队列
    class Solution {
        final int MAXN = 20010; // 节点个数
        int[][] tree = new int[MAXN][26]; // 路 : 0..25 a..z
        Map<Integer, Integer> minMp = new HashMap<>(), maxMp = new HashMap<>(); // 字典树节点-经过该节点的最小或最大下标
        int[] end = new int[MAXN];
        int[] pass = new int[MAXN];
        int cnt; // 当前分配到的位置

        void build() {
            cnt = 1;  // 0作为空，1作为根节点，记录分配到的位置
        }

        void insert(String word, int num) {
            int cur = 1;
            pass[cur]++;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;  // 分配cnt+1
                    minMp.put(tree[cur][path], num); // 记录经过节点最开始的下标
                }
                cur = tree[cur][path]; // 到下一个节点
                maxMp.put(cur, num); // 记录经过节点最后的下标
                pass[cur]++;
            }
            end[cur]++;
        }

        int[] search(String word) {
            int cur = 1;
            int l = -1, r = -1;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    return new int[]{-1, -1};
                }
                l = minMp.get(tree[cur][path]);
                r = maxMp.get(tree[cur][path]);
                cur = tree[cur][path];
            }
            return new int[]{l, r};
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products); // 按字典序排序
            int n = searchWord.length();
            build();
            for (int i = 0; i < products.length; ++i) {
                insert(products[i], i);
            }
            List<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < searchWord.length(); i++) {
                List<String> list = new ArrayList<>();
                int[] info = search(searchWord.substring(0, i + 1));
                int l = info[0], r = info[1]; //[l,r]最多三个，可能为空集
                for (int j = l; j <= Math.min(l + 2, r) && l != -1; j++) {
                    list.add(products[j]);
                }
                ans.add(list);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}