package com.leetcode.editor.cn;

import com.leetcode.helper.LeetCodeHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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
    //TODO @date 2023-12-15 bug
// 排序+二分
    // leetcode submit region begin(Prohibit modification and deletion)
    // 字典树+优先队列
    class Solution {
        final int MAXN = 150001; // 节点个数
        int[][] tree = new int[MAXN][26]; // 路 : 0..25 a..z
        PriorityQueue<String>[] threeWords = new PriorityQueue[MAXN]; // 每个节点用一个优先队列存储字典序最小的三个字符串
        int[] end = new int[MAXN];
        int[] pass = new int[MAXN];
        int cnt; // 当前分配到的位置

        void build() {
            cnt = 1;  // 0作为空，1作为根节点，记录分配到的位置
            Arrays.fill(threeWords, null);
        }

        void insert(String word) {
            int cur = 1;
            pass[cur]++;
            for (int i = 0, path; i < word.length(); i++) {
                path = word.charAt(i) - 'a';
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;  // 分配cnt+1
                }
                cur = tree[cur][path]; // 到下一个节点
                pass[cur]++;
                // 优先队列维护3个字典序最小的
                if (threeWords[cur] == null) {
                    threeWords[cur] = new PriorityQueue<>();
                }
                threeWords[cur].offer(word);
                if (threeWords[cur].size() > 3) {
                    threeWords[cur].poll();
                }
            }
            end[cur]++;
        }

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products); // 按字典序排序
            int n = searchWord.length();
            build();
            for (String product : products) {
                insert(product);
            }

            List<List<String>> ans = new ArrayList<>();
            char[] cs = searchWord.toCharArray();
            int cur = 1;
            for (int i = 0, path; i < n; ++i) {
                path = cs[i] - 'a';
                if (tree[cur][path] == 0) { // 空，后续都为空
                    ans.add(List.of());
                } else {
                    cur = tree[cur][path];
                    // 加入当前节点中优先队列的结果
                    List<String> list = new ArrayList<>();
                    while (!threeWords[cur].isEmpty()) {
                        list.add(threeWords[cur].poll());
                    }
                    ans.add(list);
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}