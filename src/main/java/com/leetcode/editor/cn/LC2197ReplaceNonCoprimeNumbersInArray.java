package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 2197 替换数组中的非互质数
public class LC2197ReplaceNonCoprimeNumbersInArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2197);
        Solution solution = new LC2197ReplaceNonCoprimeNumbersInArray().new Solution();

    }

    // 相邻元素的删除&替换 - 栈
    // REVIEW @date 2024-06-18 合并后需要继续检查合并后的数与前一个数之间的关系
    // lcm(lcm(x,y),z) = lcm(x,lcm(y,z))
    // 先和左侧的数合并，无法合并再和右侧数合并
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            List<Integer> st = new ArrayList<>();
            for (int num : nums) {
                st.add(num);
                while (st.size() > 1) {
                    int x = st.get(st.size() - 1);
                    int y = st.get(st.size() - 2);
                    int g = gcd(x, y);
                    if (g == 1) {
                        break;
                    }
                    st.remove(st.size() - 1);
                    st.set(st.size() - 1, x / g * y);
                }
            }
            return st;
        }

        private int gcd(int x, int y) {
            return y == 0 ? x : gcd(y, x % y);
        }
    }

    class Solution1 {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            for (int x : nums) {
                while (!ans.isEmpty() && gcd(ans.get(ans.size() - 1), x) > 1) { // 需要继续检查合并后的数与前一个数之间的关系
                    x = lcm(ans.remove(ans.size() - 1), x);
                }
                ans.add(x);
            }
            return ans;
        }

        // lcm(x,y) * gcd(x,y) = x * y
        // gcd
        private int gcd(int x, int y) {
            int remainder = x % y;
            while (remainder != 0) {
                x = y;
                y = remainder;
                remainder = x % y;
            }
            return y;
        }

        // lcm
        private int lcm(int x, int y) {
            return x / gcd(x, y) * y;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}