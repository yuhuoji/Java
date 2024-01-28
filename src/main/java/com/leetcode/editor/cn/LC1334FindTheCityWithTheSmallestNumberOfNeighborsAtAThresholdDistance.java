package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 1334 Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class LC1334FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1334);
        Solution solution = new LC1334FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance().new Solution();

    }

    // REVIEW @date 2023-12-31 多源最短路 Floyd
    // 递归 TLE
    // dfs(k,i,j)=min(dfs(k−1,i,j),dfs(k−1,i,k)+dfs(k−1,k,j))
    // 边界 dfs(-1,i,j) = weight(i,j) 表示 i直接连接j
    // 入口 dfs(n-1,i,j) 从i到j，节点序号小于n-1(所有节点)
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] dis;

        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            dis = new int[n][n];
            for (int[] row : dis) {
                Arrays.fill(row, Integer.MAX_VALUE / 2); // 防止松弛操作加法时溢出
            }
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1], weight = edge[2];
                dis[from][to] = dis[to][from] = weight;
            }
            int ans = 0; // 城市编号
            int minCnt = n; // 到达其他城市的次数
            for (int i = 0; i < n; ++i) {
                int cnt = 0;
                for (int j = 0; j < n; ++j) {
                    if (i != j && dfs(n - 1, i, j) <= distanceThreshold) {
                        cnt++;
                    }
                }
                if (cnt <= minCnt) { // 到达城市数量最小，编号最大的
                    ans = i;
                    minCnt = cnt;
                }
            }
            return ans;
        }

        // 递归
        private int dfs(int k, int i, int j) {
            if (k < 0) {
                return dis[i][j];
            }
            return Math.min(dfs(k - 1, i, j), dfs(k - 1, i, k) + dfs(k - 1, k, j));
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}