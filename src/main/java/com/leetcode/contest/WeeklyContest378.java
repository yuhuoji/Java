package com.leetcode.contest;

import com.leetcode.helper.LeetCodeHelper;

public class WeeklyContest378 {
    public static void main(String[] args) {
        System.out.println("Leetcode contest " + 378);
        WeeklyContest378 solution = new WeeklyContest378();

        String s = "aaaa";
        System.out.println(solution.maximumLength(s));

    }

    // 子字符串
    public int maximumLength(String s) {
        return 0;
    }

    public int maximumLength1(String s) {
        int len = s.length();
        int ans = -1;
        char[] cs = s.toCharArray();
        //[i,j]
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                if (isSpecial(cs, i, j)) {
                    int cnt = countSpecialOccurrences(s, s.substring(i, j + 1));
                    if (cnt >= 3) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }

    // 仅有单一字符组成
    private boolean isSpecial(char[] cs, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (cs[i] != cs[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int countSpecialOccurrences(String s, String special) {
        int count = 0;
        int index = -1;
        while ((index = s.indexOf(special, index + 1)) != -1) {
            count++;
        }
        return count;
    }

    // or
    // 0 or 0 = 0
    // 是否有两个以上的偶数
    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;
        int even = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) == 0) {
                even++;
            }
        }
        return even >= 2;
    }
}
