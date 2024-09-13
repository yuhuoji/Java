package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2216 美化数组的最少删除数
public class LC2216MinimumDeletionsToMakeArrayBeautiful {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2216);
        Solution solution = new LC2216MinimumDeletionsToMakeArrayBeautiful().new Solution();

    }

    // 从左向右 + 相邻元素 + 消除操作 = 栈
    // 贪心 栈中的都满足要求
    // 两个相邻的相同元素，删除右侧的数
    // 每次找到所有连续的相同元素
    // 栈中元素数量为偶数可以直接加入1个;为奇数则不能与栈顶元素相同，则可以加2个（cnt>1）
    // REVIEW @date 2024-06-18 分组循环
    // ? nums[i] == nums[i + 1] CF C. Get an Even String
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDeletion(int[] nums) {
            int n = nums.length;
            int ans = 0;
            boolean odd = false;
            for (int i = 0, start; i < n; ) { // 分组循环，一次循环处理一组连续的相同数据
                start = i;
                while (i < n && nums[i] == nums[start]) {
                    i++;
                }
                int cnt = i - start; // 连续的相同元素个数
                if (!odd) {
                    ans += cnt - 1;
                    odd = true;
                } else if (cnt == 1) {
                    odd = false;
                } else {
                    ans += cnt - 2;
                }
            }
            if (odd) {
                ans++;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}