package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Map;

// 735 Asteroid Collision
public class LC735AsteroidCollision {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 735);
        Solution solution = new LC735AsteroidCollision().new Solution();
        String s = "[-2,-1,1,2]";
        System.out.println(Arrays.toString(solution.asteroidCollision(LeetCodeHelper.stringToIntegerArray(s))));
    }

    // 能碰撞
    //  爆炸一个
    //
    //  两个都爆炸 结束
    // 不能碰撞，栈空 直接加入，结束

    // REVIEW @date 2024-03-23

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] ats) {
            int n = ats.length;
            Deque<Integer> stk = new ArrayDeque<>();
            for (int x : ats) {
                boolean alive = true;
                while (alive && !stk.isEmpty() && stk.peek() > 0 && x < 0) {
                    alive = stk.peek() < -x; // x 是否存在
                    if (stk.peek() <= -x) {  // 栈顶行星爆炸
                        stk.pop();
                    }
                }
                if (alive) {
                    stk.push(x);
                }
            }

            int sz = stk.size();
            int[] ans = new int[sz];
            while (!stk.isEmpty()) {
                ans[--sz] = stk.pop();
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}