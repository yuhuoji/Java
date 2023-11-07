package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Frog Position After T Seconds
public class Leetcode1377FrogPositionAfterTSeconds {
    // TODO @date 2023-11-07
    // 1377 思考题：如果有多个目标位置呢？
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1377);
        Solution solution = new Leetcode1377FrogPositionAfterTSeconds().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1->target,
        List<Integer>[] g;
        int target;

        public double frogPosition(int n, int[][] edges, int t, int target) {
            this.target = target;
            // 建图, 无向树
            g = new ArrayList[n + 1];// 0, 1..n
            Arrays.setAll(g, value -> new ArrayList<>());
            g[1].add(0); // 减少额外判断的小技巧 dummy
            for (int[] e : edges) {
                int x = e[0];
                int y = e[1];
                g[x].add(y); // x->y
                g[y].add(x); // y->x
            }
            long product = dfs(1, 0, t);
            return product == 0 ? 0 : 1.0 / product;
        }

        // 返回儿子个数的乘积product, 没有找到target返回0
        private long dfs(int x, int fa, int time) {
            if (time == 0) { // 正好到达
                return x == target ? 1 : 0;
            }
            if (x == target) { // 到达target为叶节点
                return g[x].size() == 1 ? 1 : 0;
            }
            for (int y : g[x]) { // 遍历x的邻居
                if (y == fa) { // 遍历到父节点
                    continue;
                }
                long product = dfs(y, x, time - 1);
                if (product != 0) {
                    return product * (g[x].size() - 1);// 归时计算儿子数目
                }
            }
            return 0;
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}