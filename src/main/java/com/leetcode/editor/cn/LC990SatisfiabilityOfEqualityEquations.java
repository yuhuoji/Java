package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 990 等式方程的可满足性
public class LC990SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 990);
        Solution solution = new LC990SatisfiabilityOfEqualityEquations().new Solution();

    }

    // 并查集
// leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parent = new int[26];
        int[] size = new int[26];
        int[] stack = new int[26];

        public boolean equationsPossible(String[] equations) {
            for (int i = 0; i < 26; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            int n = equations.length;
            for (String e : equations) {
                if (e.charAt(1) == '!') {
                    continue;
                }
                // ==
                char cx = e.charAt(0), cy = e.charAt(3);
                union(cx, cy);
            }
            for (String e : equations) {
                if (e.charAt(1) == '=') {
                    continue;
                }
                // !=
                char cx = e.charAt(0), cy = e.charAt(3);
                if (find(cx) == find(cy)) {
                    return false;
                }
            }
            return true;
        }

        private int find(char cx) {
            int x = cx - 'a';
            int size = 0;
            while (parent[x] != x) {
                stack[size++] = x;
                x = parent[x];
            }
            while (size > 0) { // 路径压缩
                parent[stack[--size]] = x;
            }
            return x;
        }

        private boolean isSameSet(char cx, char cy) {
            return find(cx) == find(cy);
        }

        private void union(char cx, char cy) {
            int x = cx - 'a', y = cy - 'a';
            int px = find(cx), py = find(cy);
            if (px == py) {
                return;
            }
            if (size[px] >= size[py]) {
                parent[py] = px;
                size[px] += size[py];
            } else {
                parent[px] = py;
                size[py] += size[px];
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}