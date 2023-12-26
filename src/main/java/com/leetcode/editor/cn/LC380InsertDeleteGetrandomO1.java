package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 380 Insert Delete GetRandom O(1)
public class LC380InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 380);
        RandomizedSet solution = new LC380InsertDeleteGetrandomO1().new RandomizedSet();

    }

    // 不重复
    // 删除时用最后一个元素填充空，保证是有序容器，可以随机访问
    // leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {
        private Map<Integer, Integer> mp; // 存储下标
        private List<Integer> list;

        public RandomizedSet() {
            mp = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (list.contains(val)) {
                return false;
            }
            mp.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!list.contains(val)) {
                return false;
            }
            int valIdx = mp.get(val);
            int endVal = list.get(list.size() - 1);
            mp.put(endVal, valIdx);
            list.set(valIdx, endVal); // 用最后一个元素填空
            mp.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// leetcode submit region end(Prohibit modification and deletion)

}