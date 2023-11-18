package com.leetcode.contest;

import java.util.*;

public class WeeklyContest371 {
    public static void main(String[] args) {
        WeeklyContest371 solution = new WeeklyContest371();

        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("aywtqh", "0419"));
        list.add(Arrays.asList("aywtqh", "0523"));
        list.add(Arrays.asList("aywtqh", "0530"));
        System.out.println("ans:" + solution.findHighAccessEmployees(list).toString());

    }

    // 2934. 最大化数组末位元素的最少操作次数
    public int minOperations(int[] nums1, int[] nums2) {

        return 0;
    }

    // 2933. 高访问员工
    // 一小时[60)内，大于等于三次.i和i+2做差看是否小于60
    // 哈希表 Map<String, List<Integer>>
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> groups = new HashMap<>();
        for (var entry : access_times) {
            String name = entry.get(0), s = entry.get(1);
            int t = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2));
            groups.computeIfAbsent(name, k -> new ArrayList<>()).add(t); //REVIEW @date 2023-11-18 Map computeIfAbsent方法
        }

        List<String> ans = new ArrayList<>();
        for (var entry : groups.entrySet()) {
            List<Integer> a = entry.getValue();
            Collections.sort(a);
            for (int i = 2; i < a.size(); i++) {
                if (a.get(i) - a.get(i - 2) < 60) {
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        return ans;
    }

    // TODO @date 2023-11-18
    // LC 421 异或和
    // 2932. 找出强数对的最大异或值 I
    // 2935. 找出强数对的最大异或值 II
    // x>=y/2
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int ans = 0; // xor最小为0
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                if (nums[j] - nums[i] > nums[i]) {
                    break;
                }
                // System.out.println(nums[i] + " " + nums[j]);
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }

    public int maximumStrongPairXor1(int[] nums) {
        int n = nums.length;
        int ans = 0; // xor最小为0
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] == nums[j]) {
                    continue;
                }
                if (nums[j] <= 2 * nums[i]) {
                    System.out.println(nums[i] + " " + nums[j]);
                    ans = Math.max(ans, nums[i] ^ nums[j]);
                }
            }
        }
        return ans;
    }
}
