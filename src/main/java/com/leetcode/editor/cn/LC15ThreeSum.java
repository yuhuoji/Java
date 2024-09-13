package com.leetcode.editor.cn;

import com.leetcode.helper.LeetCodeHelper;

import java.util.*;

// 15 3Sum
public class LC15ThreeSum {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 15);
        Solution solution = new LC15ThreeSum().new Solution();
        System.out.println(solution.threeSum(LeetCodeHelper.stringToIntegerArray("[0,0,0]")));
    }


    // REVIEW @date 2024-07-23 双指针；lc1

    // leetcode submit region begin(Prohibit modification and deletion)
    // 答案输出数，答案中不能重复
    class Solution {
        // 排序+双指针
        public List<List<Integer>> threeSum11(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < n - 2; ++i) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                if (nums[i + 1] + nums[i + 2] > target) {
                    break;
                }
                if (nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                for (int j = i + 1, k = n - 1; j < n; ++j) { // j和k一共走了n
                    if (j != i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    while (j < k && nums[j] + nums[k] > target) {
                        k--;
                    }
                    if (j == k) {
                        break;
                    }
                    if (nums[j] + nums[k] == target) {
                        ans.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
            return ans;
        }

        // lc1 O(N)
        // 哈希
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            // [i] [j] [k]
            //  x   y   z
            for (int i = 0; i < n; ++i) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                // lc1
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1; j < n; ++j) {
                    if (set.contains(nums[j])) {
                        ans.add(List.of(nums[i], target - nums[j], nums[j]));
                        while (j < n - 1 && nums[j] == nums[j + 1]) { // 避免重复
                            j++;
                        }
                    } else {
                        set.add(-nums[i] - nums[j]);
                    }
                }
            }
            return ans;
        }

        // 枚举O(N^3)
        // 双指针
        // 两个剪枝
        public List<List<Integer>> threeSum1(int[] nums) {
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