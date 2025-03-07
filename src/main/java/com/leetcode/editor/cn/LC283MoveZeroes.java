package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 283 移动零
public class LC283MoveZeroes {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 283);
        Solution solution = new LC283MoveZeroes().new Solution();

    }
// TODO @date 2025-03-07
    // REVIEW @date 2024-07-23 快排解法

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针 没有0｜都是0｜还没到的
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            int i = 0, j = 0;
            while (j < n) {
                while (i < n && nums[i] != 0) {
                    i++;
                }
                if (i > n) {
                    break;
                }
                // nums[i]=0
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

    class Solution1 {
        // 快排思想 不等于0的放在左边，等于0的放在右边，ij之间的是0
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            for (int i = 0, j = 0; j < n; ++j) {
                if (nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            }
        }

        public void moveZeroes2(int[] nums) {
            int n = nums.length;
            int cnt = 0; // 统计非0元素个数
            for (int i = 0; i < n; ++i) {
                if (nums[i] != 0) {
                    nums[cnt++] = nums[i];
                }
            }
            for (int i = cnt; i < n; ++i) {
                nums[i] = 0;
            }
        }

        public void moveZeroes1(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                while (i < n && nums[i] != 0) {
                    i++;
                }
                // nums[i]==0
                if (i == n) {
                    break;
                }
                int j = i + 1;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                // nums[j]!=0
                if (j == n) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}