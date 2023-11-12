package com.leetcode.contest;

import java.util.*;
//TODO @date 2023-11-12

public class WeeklyContest371 {
    public static void main(String[] args) {
        WeeklyContest371 solution = new WeeklyContest371();


        //[["akuhmu","0454"],["aywtqh","0523"],["akuhmu","0518"],["ihhkc","0439"],["ihhkc","0508"],["akuhmu","0529"],["aywtqh","0530"],["aywtqh","0419"]]
        List<List<String>> list = new ArrayList<>();
        // list.add(Arrays.asList("akuhmu", "0454"));
        // list.add(Arrays.asList("akuhmu", "0518"));
        // list.add(Arrays.asList("ihhkc", "0439"));
        // list.add(Arrays.asList("ihhkc", "0508"));
        // list.add(Arrays.asList("akuhmu", "0529"));
        list.add(Arrays.asList("aywtqh", "0419"));
        list.add(Arrays.asList("aywtqh", "0523"));
        list.add(Arrays.asList("aywtqh", "0530"));
        System.out.println("ans:" + solution.findHighAccessEmployees(list).toString());

        // String s = "[1,1,2,3,5]";
        // System.out.println("ans:" + solution.maximumStrongPairXor(LeetCodeHelper.stringToIntegerArray(s)));
        // System.out.println("ans1:" + solution.maximumStrongPairXor1(LeetCodeHelper.stringToIntegerArray(s)));
    }

    // 100117. 最大化数组末位元素的最少操作次数
    public int minOperations(int[] nums1, int[] nums2) {

        return 0;
    }

    // TODO @date 2023-11-12
    // 100128. 高访问员工
    // 一小时[60)内，大于等于三次.i和i+2做差看是否小于60
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        access_times.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1).compareTo(b.get(1));
            } else {
                return a.get(0).compareTo(b.get(0));
            }
        });
        List<String> ans = new ArrayList<>();

        int n = access_times.size();
        String last = null;
        for (int i = 0; i < n; ++i) {
            String name = access_times.get(i).get(0);
            if (name.equals(last)) {
                continue;
            }
            int cnt = 0;
            while (i + 2 < n && access_times.get(i + 2).get(0).equals(name)) {
                int hour1 = Integer.parseInt(access_times.get(i).get(1).substring(0, 2));
                int hour2 = Integer.parseInt(access_times.get(i + 2).get(1).substring(0, 2));
                int time1 = Integer.parseInt(access_times.get(i).get(1).substring(2, 4));
                int time2 = Integer.parseInt(access_times.get(i + 2).get(1).substring(2, 4));
                int minutes1 = hour1 * 60 + time1;
                int minutes2 = hour2 * 60 + time2;
                if (minutes2 - minutes1 < 60) {
                    cnt++;
                }
                i++;
            }
            if (cnt > 0) {
                ans.add(name);
            }

            last = name;
        }

        return ans;
    }


    // 100120. 找出强数对的最大异或值 I
    // 100124. 找出强数对的最大异或值 II
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
