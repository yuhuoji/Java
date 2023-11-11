package com.leetcode.editor.cn;

import java.util.*;

public class LC187RepeatedDnaSequences {
    static int L = 10; //base= 10

    public static void main(String[] args) {
        System.out.println("LC " + 187);
        Solution solution = new LC187RepeatedDnaSequences().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //TODO @date 2023-11-05 滚动hash

        //长度为10，出现(至少)两次
        //滑动窗口
        public List<String> findRepeatedDnaSequences(String s) {
            int n = s.length();
            List<String> ans = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            for (int j = L; j <= n; ++j) { //枚举右端点
                String t = s.substring(j - L, j); //substring左闭右开
                map.put(t, map.getOrDefault(t, 0) + 1);
                if (map.get(t) == 2) {
                    ans.add(t);
                }
            }

//            //遍历hashmap
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                if (entry.getValue() >= 2) {
//                    ans.add(entry.getKey());
//                }
//            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}