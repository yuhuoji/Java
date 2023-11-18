package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 839 Similar String Groups
public class LC839SimilarStringGroups {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 839);
        Solution solution = new LC839SimilarStringGroups().new Solution();

    }

    // 相似则合并(可以连续)，最后返回组数
    // diff等于0或2为相似
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MAXN = 301;
        int[] father = new int[MAXN];
        int setsNumber;

        // 时间O(N^3)
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            int len = strs[0].length();
            build(n);
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (find(i) == find(j)) {
                        continue;
                    }
                    // 比较[i]和[j]是否相似
                    int diff = 0;
                    for (int k = 0; k < len && diff < 3; ++k) { // 逐位比较O(N)
                        if (strs[i].charAt(k) != strs[j].charAt(k)) {
                            diff++;
                        }
                    }
                    if (diff == 0 || diff == 2) { // 相似就合并
                        union(i, j);
                    }
                }
            }
            return setsNumber;
        }

        void build(int n) {
            for (int i = 0; i < n; ++i) { // 0..n-1
                father[i] = i;
            }
            setsNumber = n;
        }

        int find(int i) {
            if (i != father[i]) {
                father[i] = find(father[i]);
            }
            return father[i]; // 代表节点自己指向自己
        }

        boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                father[find(x)] = find(y);
                setsNumber--;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}