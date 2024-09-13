package com.leetcode.editor.cn;

import com.leetcode.helper.*;

// 2266 统计打字方案数
public class LC2266CountNumberOfTexts {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 2266);
        Solution solution = new LC2266CountNumberOfTexts().new Solution();
        String s = "88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555";
        System.out.println(solution.countTexts(s));
    }

    // REVIEW @date 2024-07-09 int溢出，先转成long相加再取模再转回int
    // 分组循环找到相同的数 * 内部统计dp统计次数
    // 7 9 是4种
    // 其他为3种
    // f[i]=f[i-1]+ f[i-2]+ f[i-3]+ 可能f[i-4]
// leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        // 预处理 f ，g表示“7”和“9”
        static final int MOD = (int) (1e9 + 7), MX = (int) (1e5 + 1);
        static final int[] f = new int[MX], g = new int[MX];

        static {
            f[0] = g[0] = 1;
            f[1] = g[1] = 1;
            f[2] = g[2] = 2;
            f[3] = g[3] = 4;
            for (int i = 4; i < MX; ++i) {
                f[i] = (int) (((long) f[i - 1] + f[i - 2] + f[i - 3]) % MOD); //！！！int溢出，先转成long相加再转回int
                g[i] = (int) (((long) g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD);
            }
        }

        public int countTexts(String pressedKeys) {
            int n = pressedKeys.length();
            int ans = 1;
            int i = 0, start;
            while (i < n) {
                start = i;
                char c = pressedKeys.charAt(i);
                while (i < n && pressedKeys.charAt(i) == c) {
                    i++;
                }
                // start..i-1
                int cnt = i - start;
                if (c != '7' && c != '9') {
                    ans = (int) (((long) ans * f[cnt]) % MOD);
                } else {
                    ans = (int) (((long) ans * g[cnt]) % MOD);
                }
            }
            return ans;
        }
    }

    class Solution1 {
        private final int MOD = (int) (1e9 + 7);

        public int countTexts(String pressedKeys) {
            int n = pressedKeys.length();
            int i = 0, start;
            char[] s = pressedKeys.toCharArray();
            long ans = 1;
            while (i < n) {
                start = i;
                char c = s[start];
                while (i < n && s[i] == c) {
                    i++;
                }
                boolean isFour = s[start] == '7' || s[start] == '9'; // 7 9 是4种，其余都是三种
                // start..i-1
                int len = i - start;
                // f[i] 0..i的可能的组合数
                int[] f = new int[len + 1];
                f[0] = 1;
                for (int j = 1; j <= len; ++j) {
                    for (int k = 1; k <= 3; ++k) {
                        if (j >= k) {
                            f[j] = (f[j] + f[j - k]) % MOD;
                        }
                    }
                    if (j >= 4 && isFour) {
                        f[j] = (f[j] + f[j - 4]) % MOD;
                    }
                }
                // 返回f[len]
                ans = (ans * f[len]) % MOD;
            }
            return (int) ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}