package com.leetcode.editor.cn;

// LCR 120 寻找文件副本
public class LCLCR120ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        System.out.println("Leetcode " + "LCR 120");
        Solution solution = new LCLCR120ShuZuZhongZhongFuDeShuZiLcof().new Solution();

    }
    // REVIEW @date 2024-08-12 把数组视为哈希表
    // 0 ≤ documents[i] ≤ n-1
    // docs[i]应该放到docs[i]位置,docs[i]=i

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatDocument(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) {
                        return nums[i];
                    }
                    swap(nums, nums[i], i);
                }
            }
            throw new IllegalArgumentException("没有答案");
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}