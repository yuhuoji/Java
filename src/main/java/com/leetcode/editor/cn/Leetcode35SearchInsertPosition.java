package com.leetcode.editor.cn;

import com.leetcode.helper.*;

//35 Search Insert Position
public class Leetcode35SearchInsertPosition{
    public static void main(String[] args) {
        System.out.println("Leetcode " + 35);
        Solution solution = new Leetcode35SearchInsertPosition().new Solution();
        
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n; //[0,n) [l,r)
        while (l < r) {
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int m = ((r - l) >> 1) + l;
            if (target <= nums[m]) {
                r = m; //[l,m)
            } else {
                l = m + 1; //[m,r)
            }
        }
        // l==r
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}