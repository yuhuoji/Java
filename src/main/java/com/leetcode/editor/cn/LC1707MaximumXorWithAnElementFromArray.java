package com.leetcode.editor.cn;

import com.leetcode.helper.LeetCodeHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1707 Maximum XOR With an Element From Array
public class LC1707MaximumXorWithAnElementFromArray {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 1707);
        // Solution solution = new LC1707MaximumXorWithAnElementFromArray().new Solution();

        // System.out.println(Math.log(Math.pow(10, 9)) / Math.log(2));

        int[] nums = LeetCodeHelper.stringToIntegerArray("[245405671,478954451,192656583,756912244,536870912,536870912,632641004,536870912,536870912,885997335,66102331,96363044,456847995,969641794,56056493,929047056,239297896,536870912,36418831,394600426]");

        int[][] queries = LeetCodeHelper.stringTo2DIntArray("[[509227044,637282201],[759706,926411389],[3212316,9],[1000000000,1000000000],[297996899,1000000000],[572469597,1000000000],[134431215,1000000000],[3849770,1000000000],[740964597,4096],[1000000000,1000000000],[687608329,4096],[339477185,626514388],[235661081,1000000000],[1000000000,1000000000],[969657177,1051],[1000000000,1000000000],[1000000000,1000000000],[706847,1000000000],[3085345,710403333],[345073691,1000000000]]");

        // System.out.println(Arrays.toString(solution.maximizeXor(nums, queries)));
    }
    // mp + trie添加小于m的数字，求最大异或
    // static优化，否则TLE
    // leetcode submit region begin(Prohibit modification and deletion)
/*    class Solution {
        static final int HIGH_BIT = 30; // log_2(10^9) = 29...
        static final int MAXN = 100_001 * 32; // 根据数据范围估算
        static int[][] tree = new int[MAXN][2]; // 只存0 1
        static int[] end = new int[MAXN];
        static int[] pass = new int[MAXN];
        static int cnt; // 0表示没用过，1作为根节点

        public int[] maximizeXor(int[] nums, int[][] queries) {
            int n = nums.length;
            int len = queries.length;
            Map<int[], Integer> mp = new HashMap<>(); // 记录queries下标
            for (int i = 0; i < len; ++i) {
                mp.put(queries[i], i);
            }
            Arrays.sort(nums); // 排序
            Arrays.sort(queries, (a, b) -> a[1] - b[1]); // 按照第二个元素排序 m升序

            int[] ans = new int[len];
            int p = 0; // nums[0, p) 放入trie
            build();
            for (int[] query : queries) {
                int x = query[0], m = query[1];
                // max(nums[j] XOR xi), nums[j] <= m
                while (p < n && nums[p] <= m) {
                    insert(nums[p++]);
                }
                ans[mp.get(query)] = p == 0 ? -1 : getMaxXor(x);
            }
            clear();
            return ans;
        }

        public void build() {
            cnt = 1;
        }

        public void insert(int num) {
            int cur = 1;
            pass[cur]++;
            for (int i = HIGH_BIT; i >= 0; --i) {
                int path = (num >> i) & 1; // 取第i位
                if (tree[cur][path] == 0) {
                    tree[cur][path] = ++cnt;  // 分配cnt+1
                }
                cur = tree[cur][path];
                pass[cur]++;
            }
            end[cur]++;
        }

        public int search(int num) {
            int cur = 1;
            for (int i = HIGH_BIT; i >= 0; --i) {
                int path = (num >> i) & 1;
                if (tree[cur][path] == 0) {
                    return 0;
                }
                cur = tree[cur][path];
            }
            return end[cur];
        }

        public int prefixNumber(int pre) {
            int cur = 1;
            for (int i = HIGH_BIT; i >= 0; --i) {
                int path = (pre >> i) & 1;
                if (tree[cur][path] == 0) {
                    return 0;
                }
                cur = tree[cur][path];
            }
            return pass[cur];
        }

        public void delete(int num) {
            if (search(num) > 0) {
                int cur = 1;
                for (int i = HIGH_BIT; i >= 0; --i) {
                    int path = (num >> i) & 1;
                    if (--pass[tree[cur][path]] == 0) {
                        tree[cur][path] = 0;
                        return;
                    }
                    cur = tree[cur][path];
                }
                end[cur]--;
            }
        }

        public void clear() {
            for (int i = 1; i <= cnt; i++) {
                Arrays.fill(tree[i], 0);
                end[i] = 0;
                pass[i] = 0;
            }
        }

        public int getMaxXor(int num) {
            int cur = 1;
            int ans = 0;
            for (int i = HIGH_BIT; i >= 0; --i) {
                int path = (num >> i) & 1;
                if (tree[cur][path ^ 1] != 0) {
                    ans |= (1 << i);
                    path ^= 1;
                }
                cur = tree[cur][path];
            }
            return ans;
        }
    }*/
// leetcode submit region end(Prohibit modification and deletion)


    // 类实现
       /* class Trie1 {
            private final int HIGH_BIT = 30; // 根据数据范围估算 log_2(10^9) = 29...
            public TrieNode root;

            public Trie1() {
                root = new TrieNode();
            }

            public void insert(int num) {
                TrieNode node = root;
                node.pass++;
                for (int i = HIGH_BIT, path; i >= 0; --i) { // 从高位到低位依次插入
                    path = (num >> i) & 1; // 第i位是0还是1
                    if (node.nexts[path] == null) {
                        node.nexts[path] = new TrieNode();
                    }
                    node = node.nexts[path];
                    node.pass++;
                }
                node.end++;
            }

            public void erase(int num) {
                if (countWordsEqualTo(num) > 0) { // 存在
                    TrieNode node = root;
                    node.pass--;
                    for (int i = HIGH_BIT, path; i >= 0; --i) {
                        path = (num >> i) & 1;
                        if (--node.nexts[path].pass == 0) {
                            node.nexts[path] = null;
                            return;
                        }
                        node = node.nexts[path];
                    }
                    node.end--;
                }
            }

            public int countWordsEqualTo(int num) {
                TrieNode node = root;
                for (int i = HIGH_BIT, path; i >= 0; --i) {
                    path = (num >> i) & 1;
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.end;
            }

            public int countWordsStartingWith(int num) {
                TrieNode node = root;
                for (int i = HIGH_BIT, path; i >= 0; --i) {
                    path = (num >> i) & 1;
                    if (node.nexts[path] == null) {
                        return 0;
                    }
                    node = node.nexts[path];
                }
                return node.pass;
            }

            public int getMaxXor(int num) {
                TrieNode node = root;
                int ans = 0;
                for (int i = HIGH_BIT; i >= 0; --i) {
                    int path = (num >> i) & 1;
                    if (node.nexts[path ^ 1] != null) {
                        ans |= (1 << i);
                        path ^= 1;
                    }
                    node = node.nexts[path];
                }
                return ans;
            }

            private class TrieNode {
                public int pass;
                public int end;
                public TrieNode[] nexts;

                public TrieNode() {
                    pass = 0;
                    end = 0;
                    nexts = new TrieNode[2]; // 0 1
                }
            }

        }
        */
}