package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import javax.xml.stream.events.StartDocument;
import java.util.*;

// 2770 Maximum Number of Jumps to Reach the Last Index
public class LC2770MaximumNumberOfJumpsToReachTheLastIndex {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "2770");
        Solution solution = new LC2770MaximumNumberOfJumpsToReachTheLastIndex().new Solution();

    }
    // dp
    // if -target <= nums[i] - nums[j] <= target
    // dfs(i)=dfs(j)+1, 所有可能的dfs(i)取max
    // 没有则dfs(i)=-inf
    // 入口dfs(0)=0
    // 返回dfs(n-1), 没有则返回-1

    // if -target <= nums[i] - nums[j] <= target
    // f[i]=f[j]+1, 所有可能的f[i]取max
    // 没有则f[i]=-inf
    // 入口f[0]=0
    // 返回f[n-1], 没有则返回-1

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumJumps(int[] nums, int target) {
            int n = nums.length;
            int[] f = new int[n]; // f[0]=0
            for (int i = 1; i < n; ++i) {
                int res = Integer.MIN_VALUE;
                for (int j = 0; j < i; ++j) {
                    if (Math.abs(nums[i] - nums[j]) <= target) {
                        res = Math.max(res, f[j] + 1);
                    }
                    f[i] = res;
                }
            }
            return f[n - 1] < 0 ? -1 : f[n - 1];
        }
    }

    class Solution1 {
        private int target;
        private int[] nums;

        public int maximumJumps(int[] nums, int target) {
            int n = nums.length;
            this.nums = nums;
            this.target = target;
            int ans = dfs(n - 1);
            return ans < 0 ? -1 : ans;
        }

        private int dfs(int i) {
            if (i == 0) {
                return 0;
            }
            int res = Integer.MIN_VALUE;
            for (int j = 0; j < i; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    res = Math.max(res, dfs(j) + 1);
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}