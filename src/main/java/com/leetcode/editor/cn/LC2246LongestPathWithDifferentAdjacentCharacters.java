package com.leetcode.editor.cn;

import com.leetcode.helper.*;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Longest Path With Different Adjacent Characters
public class LC2246LongestPathWithDifferentAdjacentCharacters {
    //REVIEW @date 2023-11-06 树上dp模板
    public static void main(String[] args) {
        System.out.println("LC " + 2246);
        Solution solution = new LC2246LongestPathWithDifferentAdjacentCharacters().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer>[] g; //记录所有邻居（不包含父节点
        String s;
        int ans;

        public int longestPath(int[] parent, String s) {
            this.s = s;
            int n = parent.length;
            g = new ArrayList[n];
            Arrays.setAll(g, value -> new ArrayList<>());
            for (int i = 1; i < n; ++i) { //从1开始，parent[i] -> i
                g[parent[i]].add(i);
            }
            ans = 0;
            dfs(0, -1); //从根节点开始
            return ans + 1; //点=边+1
        }

        //dfs(x)邻居不包含父节点，dfs(x,fa)包含父节点
        int dfs(int x, int fa) {
            int xLen = 0;
            for (int y : g[x]) { //遍历x的邻居
                if (y == fa) { //y=父节点
                    continue;
                }
                int yLen = dfs(y, x) + 1;
                if (s.charAt(x) != s.charAt(y)) {
                    ans = Math.max(ans, xLen + yLen);
                    xLen = Math.max(xLen, yLen);
                }
            }
            return xLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}