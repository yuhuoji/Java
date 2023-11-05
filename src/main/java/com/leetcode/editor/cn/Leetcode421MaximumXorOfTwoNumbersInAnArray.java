package com.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode421MaximumXorOfTwoNumbersInAnArray {
    public static void main(String[] args) {
        System.out.println("Leetcode" + 421);
        Solution solution = new Leetcode421MaximumXorOfTwoNumbersInAnArray().new Solution();
        int[] nums = {3, 10, 5, 25, 2, 8};

        System.out.println(solution.findMaximumXOR(nums));

//        int a = 0b100100;
//        int highBit = 31 - Integer.numberOfLeadingZeros(a);  //numberOfLeadingZeros 前导零的数量
//        int lowBit = Integer.numberOfTrailingZeros(a);
//        System.out.println(highBit);
//        System.out.println(lowBit);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //REVIEW @date 2023-11-04
        //让第一位1出现在尽量左的位置
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int x : nums) {
                max = Math.max(max, x);
            }
            int highBit = 31 - Integer.numberOfLeadingZeros(max); //获取最高位

            int ans = 0, mask = 0;
            Set<Integer> seen = new HashSet<>();
            for (int i = highBit; i >= 0; i--) { //从最高位开始尝试
                seen.clear();
                mask |= (1 << i); //mask
                int newAns = ans | (1 << i);
                for (int x : nums) {
                    x &= mask; //让x低于i位置为0
                    if (seen.contains(newAns ^ x)) {//如果存在一个数y，使得y ^ x = newAns，那么newAns ^ x = y
                        ans = newAns;
                        break;
                    }
                    seen.add(x);
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}