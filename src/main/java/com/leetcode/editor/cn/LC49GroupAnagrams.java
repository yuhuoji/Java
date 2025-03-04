package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 49 字母异位词分组
public class LC49GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 49);
        Solution solution = new LC49GroupAnagrams().new Solution();

    }
    // REVIEW @date 2025-03-04
    //  哈希表 map.computeIfAbsent 的使用


    // 哈希 tan nat所得哈希值应该相同-》排序
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int n = strs.length;
            Map<String, List<String>> mp = new HashMap<>();
            for (String str : strs) {
                char[] s = str.toCharArray();
                Arrays.sort(s);
                // String key = new String(s); // Arrays.toString(s)
                // if (!mp.containsKey(key)) {
                //     mp.put(key, new ArrayList<>());
                // }
                // mp.get(key).add(string);
                mp.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(mp.values());
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}