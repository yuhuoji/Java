package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 1431 Kids With the Greatest Number of Candies
public class LC1431KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1431);
        Solution solution = new LC1431KidsWithTheGreatestNumberOfCandies().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int mx = 0;
            for (int x : candies) {
                mx = Math.max(mx, x);
            }
            List<Boolean> ans = new ArrayList<>();
            for (int x : candies) {
                ans.add(x + extraCandies >= mx);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}