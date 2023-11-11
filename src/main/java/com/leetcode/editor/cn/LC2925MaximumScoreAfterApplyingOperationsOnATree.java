package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2925 Maximum Score After Applying Operations on a Tree
public class LC2925MaximumScoreAfterApplyingOperationsOnATree {
    public static void main(String[] args) {
        System.out.println("LC " + 2925);
        Solution solution = new LC2925MaximumScoreAfterApplyingOperationsOnATree().new Solution();

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}};
        int[] values = {1000000000, 1000000000, 1000000000, 1000000000};
        long ans = solution.maximumScoreAfterOperations(edges, values);
        System.out.println(ans);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] g;
        int[] values;

        // 正难则反，先全选了，再选一些节点满足题目限制（子树是健康的）, ans = sum - min{满足要求选的}
        // 要排除的节点和最小
        // 选或不选，dfs(x)
        // 选根节点，损失根节点的分数=value[x], 结束，不需要递归
        // 不选根节点，获得根节点的分数=sum{dfs(y)}
        // 返回min
        public long maximumScoreAfterOperations(int[][] edges, int[] values) {
            int n = values.length;
            this.values = values;
            g = new ArrayList[n];
            Arrays.setAll(g, value -> new ArrayList<>());
            g[0].add(-1); // 让根节点的邻居个数大于1，
            for (int[] e : edges) {
                int x = e[0], y = e[1];
                g[x].add(y);
                g[y].add(x);
            }
            long sum = 0;
            for (int v : values) {
                sum += v;
            }
            return sum - dfs(0, -1);
        }

        long dfs(int x, int fa) {
            if (g[x].size() == 1) { // 递归到叶节点，父节点都没选，叶节点必须选
                return values[x];
            }
            long loss1 = values[x];
            long loss2 = 0;
            for (int y : g[x]) {
                if (y == fa) {
                    continue;
                }
                loss2 += dfs(y, x);
            }
            return Math.min(loss1, loss2);
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}