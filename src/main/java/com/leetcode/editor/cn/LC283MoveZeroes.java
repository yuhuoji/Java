package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 283 移动零
public class LC283MoveZeroes {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 283);
        Solution solution = new LC283MoveZeroes().new Solution();

    }

    // REVIEW @date 2025-03-12

    // leetcode submit region begin(Prohibit modification and deletion)

    // 快慢指针 保持顺序，用i0记录第一个0的位置，i与i0交换
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int i0 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] != 0) {
                    int tmp = nums[i0];
                    nums[i0] = nums[i];
                    nums[i] = tmp;
                    i0++;
                }
            }
        }
    }

    class Solution2 {
        // 统计非0元素个数
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int cnt = 0; // 非0元素
            for (int i = 0; i < n; ++i) {
                if (nums[i] != 0) {
                    nums[cnt] = nums[i];
                    cnt++;
                }
            }
            for (int i = cnt; i < n; ++i) {
                nums[i] = 0;
            }
        }
    }

    class Solution1 {
        // 双指针 i找第一个0，j找第一个非零
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int i = 0, j = 0;
            while (true) {
                while (i < n && nums[i] != 0) {
                    i++;
                }
                if (i >= n) {
                    break;
                }
                // nums[i]=0
                j = i + 1;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                if (j >= n) {
                    break;
                }
                // nums[j]!=0
                // 交换ij
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}