package com.leetcode.editor.cn;

import com.leetcode.helper.*;

import java.util.*;

// 381 Insert Delete GetRandom O(1) - Duplicates allowed
public class LC381InsertDeleteGetrandomO1DuplicatesAllowed {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 381);
        RandomizedCollection solution = new LC381InsertDeleteGetrandomO1DuplicatesAllowed().new RandomizedCollection();

    }

    // REVIEW @date 2023-12-26
    // 允许重复
// leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {
        private Map<Integer, Set<Integer>> mp;
        private List<Integer> list;

        public RandomizedCollection() {
            mp = new HashMap<>();
            list = new ArrayList<>();
        }

        // Returns true if the item is not present, false otherwise.
        public boolean insert(int val) {
            list.add(val);
            Set<Integer> st = mp.getOrDefault(val, new HashSet<>());
            st.add(list.size() - 1);
            mp.put(val, st);
            return st.size() == 1;
        }

        // 用最后一个元素填空
        public boolean remove(int val) {
            if (!list.contains(val)) {
                return false;
            }
            Set<Integer> valSet = mp.get(val);
            int valIdx = valSet.iterator().next(); // 获取一个待删除元素的下标
            int endVal = list.get(list.size() - 1);
            if (val == endVal) { // 最后一个元素等于待删除的元素，可以直接删除最后一个元素
                valSet.remove(list.size() - 1);
            } else { // 用最后一个元素替换
                Set<Integer> endValSet = mp.get(endVal);
                endValSet.add(valIdx);
                list.set(valIdx, endVal);
                endValSet.remove(list.size() - 1);
                valSet.remove(valIdx);
            }
            if (valSet.isEmpty()) { // 删除元素后为空
                mp.remove(val);
            }
            list.remove(list.size() - 1); // 删除最后一个元素
            return true;
        }

        public int getRandom() {
            return list.get((int) (Math.random() * list.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// leetcode submit region end(Prohibit modification and deletion)

}