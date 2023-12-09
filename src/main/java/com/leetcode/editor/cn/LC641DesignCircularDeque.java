package com.leetcode.editor.cn;

// 641 Design Circular Deque
public class LC641DesignCircularDeque {
    public static void main(String[] args) {
        System.out.println("Leetcode " + 641);
        int k = 10;
        MyCircularDeque circularDeque = new LC641DesignCircularDeque().new MyCircularDeque(k);

    }

    // 循环数组实现双端队列
    // leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        private int[] deque;
        private int l, r, size, capacity;

        public MyCircularDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
            capacity = k; // 容量最大为k
        }

        //[l,r] l--
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) { // 放在0位置
                l = r = 0;
                deque[0] = value;
            } else {
                // l在0位置
                l = l == 0 ? capacity - 1 : l - 1;
                deque[l] = value;
            }
            size++;
            return true;
        }

        // r++
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                // r在最后一位
                r = r == capacity - 1 ? 0 : r + 1;
                deque[r] = value;
            }
            size++;
            return true;
        }

        // l++
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            l = l == capacity - 1 ? 0 : l + 1;
            size--;
            return true;
        }

        // r--
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            r = r == 0 ? capacity - 1 : r - 1;
            size--;
            return true;
        }

        //Returns -1 if the deque is empty.
        public int getFront() {
            if (isEmpty()){
                return -1;
            }
            return deque[l];
        }

        public int getRear() {
            if (isEmpty()){
                return -1;
            }
            return deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// leetcode submit region end(Prohibit modification and deletion)

}