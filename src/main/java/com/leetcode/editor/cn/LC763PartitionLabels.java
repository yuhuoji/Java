package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 763 Partition Labels
public class LC763PartitionLabels {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 763);
        Solution solution = new LC763PartitionLabels().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            List<Integer> ans = new ArrayList<>();
            char[] chars = s.toCharArray();
            int start = 0, end = 0;
            int[] last = new int[26]; // 统计字符最右端出现的位置
            for (int i = 0; i < n; ++i) {
                last[chars[i] - 'a'] = i;
            }
            //[]
            for (int i = 0; i < n; ++i) {
                char c = chars[i];
                end = Math.max(end, last[c - 'a']);
                if (i == end) {
                    ans.add(end - start + 1);
                    start = end + 1;
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}