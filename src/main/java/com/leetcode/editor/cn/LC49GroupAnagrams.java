package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 49 字母异位词分组
public class LC49GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 49);
        Solution solution = new LC49GroupAnagrams().new Solution();

    }
    //REVIEW @date 2024-07-22 哈希表使用 map.computeIfAbsent

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> mp = new HashMap<>();
            for (String str : strs) {
                char[] s = str.toCharArray();
                Arrays.sort(s);
                mp.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(mp.values());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}