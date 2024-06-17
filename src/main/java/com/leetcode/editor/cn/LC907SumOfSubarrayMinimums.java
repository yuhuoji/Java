package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//907 子数组的最小值之和
public class LC907SumOfSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 907);
        Solution solution = new LC907SumOfSubarrayMinimums().new Solution();

    }

    //左边界找<a[i]的数的下标，右边界找<=a[i]的数的下标，防止重叠
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        //arr=[1,2,4,2,3,1]
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;

            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);
            Deque<Integer> st = new ArrayDeque<>();
            st.push(-1); //最左侧
            for (int i = 0; i < n; ++i) {
                while (st.size() > 1 && arr[st.peek()] >= arr[i]) {
                    right[st.pop()] = i;
                }
                left[i] = st.peek();
                st.push(i);
            }

            long ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
            }
            return (int) (ans % MOD);
        }

        public int sumSubarrayMins1(int[] arr) {
            int n = arr.length;

            int[] left = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            st.push(-1); //最左侧
            for (int i = 0; i < n; ++i) {
                while ( st.size() > 1 && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                left[i] = st.peek();
                st.push(i);
            }

            int[] right = new int[n];
            st.clear();
            st.push(n); //最右侧
            for (int i = n - 1; i >= 0; --i) {
                while (st.size() > 1 && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                right[i] = st.peek();
                st.push(i);
            }

            long ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += (long) arr[i] * (i - left[i]) * (right[i] - i);
            }
            return (int) (ans % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}