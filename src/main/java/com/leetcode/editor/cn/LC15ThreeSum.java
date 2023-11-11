package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15 3Sum
public class LC15ThreeSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 15);
        Solution solution = new LC15ThreeSum().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    // 不能重复
    class Solution {
        // 枚举O(N^3)
        // 双指针
        // 两个剪枝
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int first = 0; first < n - 2; ++first) { // 枚举i
                if (first != 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int target = -nums[first];
                // 两个优化
                if (nums[first + 1] + nums[first + 2] > target) {// 1.后续循环无解
                    break;
                }
                if (nums[n - 2] + nums[n - 1] < target) {// 2.本层循环无解
                    continue;
                }
                for (int second = first + 1, third = n - 1; second < n - 1; ++second) { // 枚举j
                    if (second != first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    while (second < third && nums[second] + nums[third] > target) {
                        third--;
                    }
                    if (second == third) {// 无解
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}