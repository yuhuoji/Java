package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 399 除法求值
public class LC399EvaluateDivision {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 399);
        Solution solution = new LC399EvaluateDivision().new Solution();

    }

    // REVIEW @date 2024-07-01 并查集
    // 一边查询一边修改结点指向是并查集的特色
    // LC990
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int equationsSize = equations.size();
            UnionFind unionFind = new UnionFind(2 * equationsSize);
            Map<String, Integer> hashMap = new HashMap<>();
            int id = 0; // 变量值和id映射
            for (int i = 0; i < equationsSize; ++i) {
                List<String> equation = equations.get(i);
                String s1 = equation.get(0);
                String s2 = equation.get(1);
                if (!hashMap.containsKey(s1)) {
                    hashMap.put(s1, id++);
                }
                if (!hashMap.containsKey(s2)) {
                    hashMap.put(s2, id++);
                }
                unionFind.union(hashMap.get(s1), hashMap.get(s2), values[i]);
            }
            // 查询
            int queriesSize = queries.size();
            double[] ans = new double[queriesSize];
            for (int i = 0; i < queriesSize; ++i) {
                String s1 = queries.get(i).get(0);
                String s2 = queries.get(i).get(1);
                Integer id1 = hashMap.get(s1);
                Integer id2 = hashMap.get(s2);
                if (id1 == null || id2 == null) {
                    ans[i] = -1.0d;
                } else {
                    ans[i] = unionFind.isSameSet(id1, id2);
                }
            }
            return ans;
        }

        class UnionFind {
            UnionFind(int n) {
                parent = new int[n];
                weight = new double[n];
                for (int i = 0; i < n; ++i) {
                    parent[i] = i;
                    weight[i] = 1.0d;
                }
            }

            int[] parent;
            double[] weight;

            private int find(int x) {
                if (parent[x] != x) {
                    int origin = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[origin];
                }
                return parent[x];
            }

            private double isSameSet(int x, int y) {
                if (find(x) == find(y)) {
                    return weight[x] / weight[y];
                } else {
                    return -1.0d;
                }
            }

            // x挂y, x/y = v
            private void union(int x, int y, double value) {
                int px = find(x), py = find(y);
                if (px == py) {
                    return;
                }
                parent[px] = py;
                weight[px] = weight[y] * value / weight[x]; // 更新权值
            }
        }


    }
// leetcode submit region end(Prohibit modification and deletion)

}