package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.Arrays;

// 2976 Minimum Cost to Convert String I
public class LC2976MinimumCostToConvertStringI {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2976);
        Solution solution = new LC2976MinimumCostToConvertStringI().new Solution();

    }
    // todo 加强版 Q4 2977
    // REVIEW @date 2023-12-27 Floyd
    // dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j])

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            int[][] dis = new int[26][26]; //[i][j] i -> j 的花费
            for (int i = 0; i < 26; ++i) {
                Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
                dis[i][i] = 0; // 对角线
            }
            for (int i = 0; i < cost.length; ++i) {
                int x = original[i] - 'a';
                int y = changed[i] - 'a';
                dis[x][y] = Math.min(dis[x][y], cost[i]); // x->y
            }
            for (int k = 0; k < 26; ++k) {
                for (int i = 0; i < 26; ++i) {
                    for (int j = 0; j < 26; ++j) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }

            long ans = 0;
            for (int i = 0; i < source.length(); ++i) {
                int d = dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (d == Integer.MAX_VALUE / 2) {
                    return -1;
                }
                ans += d;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}