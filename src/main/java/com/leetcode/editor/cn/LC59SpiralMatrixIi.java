package com.leetcode.editor.cn;

import com.leetcode.helper.*;

//59 Spiral Matrix II
public class LC59SpiralMatrixIi{
    public static void main(String[] args) {
        System.out.println("LC " + 59);
        Solution solution = new LC59SpiralMatrixIi().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int u = 0, d = n-1, l=0,r=n-1;
        int num=1;
        while (true){
            //上
            for (int j = l; j <= r; ++j) {
                ans[u][j] = num++;
            }
            if (++u > d) {
                break;
            }
            //右
            for (int i = u; i <= d; ++i) {
                ans[i][r] = num++;
            }
            if (--r < l) {
                break;
            }
            //下
            for (int j = r; j >= l; --j) {
                ans[d][j] = num++;
            }
            if (--d < u) {
                break;
            }
            //左
            for (int i = d; i >= u; --i) {
                ans[i][l] = num++;
            }
            if (++l > r) {
                break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}