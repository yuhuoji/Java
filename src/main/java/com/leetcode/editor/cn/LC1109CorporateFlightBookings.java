package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 1109 Corporate Flight Bookings
public class LC1109CorporateFlightBookings {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1109);
        Solution solution = new LC1109CorporateFlightBookings().new Solution();

    }

    // 差分数组模板
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            int[] ans = new int[n]; // 0..n-1
            for (int[] book : bookings) {
                int first = book[0] - 1, last = book[1] - 1, seats = book[2];
                ans[first] += seats;
                if (last + 1 < n) {
                    ans[last + 1] -= seats;
                }
            }
            for (int i = 1; i < n; ++i) {
                ans[i] += ans[i - 1];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}