package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 765 Couples Holding Hands
public class LC765CouplesHoldingHands {
    // REVIEW @date 2023-11-18
    // 并查集
    // sum{每个集合数量-1} = n/2 - 集合数量
    // 一个集合里有k对情侣，需要交换k-1次
    public static void main(String[] args) {
        System.out.println("Leetcode " + 765);
        Solution solution = new LC765CouplesHoldingHands().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MAXN = 31;
        int[] father = new int[MAXN];
        int setsNumber; // 集合的数量

        public int minSwapsCouples(int[] row) {
            int n = row.length;
            build(n / 2); //开始分为n/2组
            for (int i = 0; i < n; i += 2) { // 两两合并
                union(row[i] / 2, row[i + 1] / 2);
            }
            return n / 2 - setsNumber; //(n1 - 1) + (n2 - 1) + ...
        }

        private void build(int n) {
            for (int i = 0; i <= n; ++i) { // 0..n
                father[i] = i;
            }
            setsNumber = n;
        }

        private int find(int i) {
            if (i != father[i]) {
                father[i] = find(father[i]);
            }
            return father[i];
        }

        private boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        private void union(int x, int y) {
            int fx = find(x); //x的father
            int fy = find(y);
            if (fx != fy) {
                father[fx] = fy; // x代表 -> y代表
                setsNumber--; // 集合数量减少
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}