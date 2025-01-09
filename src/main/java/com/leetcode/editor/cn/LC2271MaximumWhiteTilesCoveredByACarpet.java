package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2271 毯子覆盖的最多白色砖块数
public class LC2271MaximumWhiteTilesCoveredByACarpet {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2271");
        Solution solution = new LC2271MaximumWhiteTilesCoveredByACarpet().new Solution();

    }


    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
            Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
            int ans = 0;
            int left = 0; // 左侧在哪部分瓷砖上
            int cover = 0;
            for (int[] tile : tiles) { // 只需要枚举右端点在瓷砖最右侧
                int tl = tile[0], tr = tile[1];
                cover += tr - tl + 1;
                // 当前右端点在tr，左端点在tr-carpetLen+1
                while (tr - carpetLen + 1 > tiles[left][1]) {
                    cover -= tiles[left][1] - tiles[left][0] + 1;
                    left++;
                }
                int uncover = Math.max(tr - carpetLen + 1 - tiles[left][0], 0); // 可能完全覆盖或者只覆盖了一部分
                ans = Math.max(ans, cover - uncover);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}