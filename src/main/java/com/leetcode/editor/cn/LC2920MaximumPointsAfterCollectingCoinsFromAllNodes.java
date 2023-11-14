package com.leetcode.editor.cn;

import com.leetcode.helper.*;

//2920 Maximum Points After Collecting Coins From All Nodes
public class LC2920MaximumPointsAfterCollectingCoinsFromAllNodes{
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2920);
        Solution solution = new LC2920MaximumPointsAfterCollectingCoinsFromAllNodes().new Solution();
        int a = 10_000;
        System.out.println(Math.log(a)/Math.log(2)); //10^4右移14位为0

    }
    //两种方法，自顶向下和自底向上
    //树型dp
    //floor(x / 2) = x/2 = x>>1
    // 状态定义dfs(i,j) 当前节点i, 之前选了j次方法2
    //dfs(i,j)=
    //方法1 (coins[i] >> j) - k + sum(dfs(child,j))
    //方法2 (coins[i] >> (j+1)) + sum(dfs(child,j+1))
    //方法1方法2取max
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}