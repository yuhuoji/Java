package com.leetcode.solution;

/**
 * @date 2023-02-28 20:49
 * TODO 其他解法
 */
public class Solution69Sqrtx {
    //二分查找，分还是middle，比较变了，找边界，找最大的平方不超过x的数
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int middle = ((right - left) >> 1) + left;
            if ((long) middle * middle <= x) { //右
                ans = middle;
                left = middle + 1;
            } else { //左
                right = middle - 1;
            }
        }
        return ans;
    }
}
