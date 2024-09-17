package com.leetcode.contest;

import java.util.*;

public class WeeklyContest415 {

    public static void main(String[] args) {
        WeeklyContest415 solution = new WeeklyContest415();

    }

    //?
    public int minValidStrings(String[] words, String target) {
        return 0;
    }

    //??
    public long maxScore(int[] a, int[] b) {
        return 0;
    }

    //?? 异或
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] mp = new int[n];
        for (int x : nums) {
            mp[x]++;
        }
        for (int x : nums) {
            if (mp[x] == 2) {
                ans.add(x);
            }
        }
        return ans.stream().distinct().mapToInt(i -> i).toArray();
    }

}
