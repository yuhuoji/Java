package com.leetcode.algorithm.day1;

/**
 * @date 2023-02-28 18:45
 */
public class Leetcode278FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    private boolean isBadVersion(int version) {
        return true;
    }

    //[]
    public int firstBadVersion1(int n) { //1~n
        int left = 1, right = n;
        // k-false,k+1-true
        while (left <= right) { //left==right
            int res = (right - left) / 2 + left;
            if (isBadVersion(res - 1) == false & isBadVersion(res) == false) {
                left = res + 1;
            } else if (isBadVersion(res - 1) == true & isBadVersion(res) == true) {
                right = res - 1;
            } else {
                return res;
            }
        }
        return -1;
    }

    //减少api次数
    public int firstBadVersion(int n) { //1~n
        int left = 1, right = n;
        // k-false右侧,k-true左侧，找true和false的边界
        while (left < right) { //left==right终止找到边界ture左侧尾left
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) { //ture左侧
                right = mid;
            } else { //false右侧
                left = mid + 1;
            }
        }
        return left;
    }
}
