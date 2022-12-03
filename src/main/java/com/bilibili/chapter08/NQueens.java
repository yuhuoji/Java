package com.bilibili.chapter08;

/**
 * @date 2022-11-27 09:48
 * n皇后问题
 */
public class NQueens {
    /**
     * num1
     *
     * @param n n行n列
     * @return 解法个数
     */
    public int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n]; //record[i] -> 第i行的皇后放在哪一列
        return process1(0, record, n);
    }

    /**
     * num2 位运算常数优化
     * 不要超过32皇后问题，超过使用long类型
     *
     * @param n process1
     * @return 解法个数
     */
    public int num2(int n) {
        if (n < 1 || n > 32) { //超出适用范围
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1; //n=8 => 1 0000 0000  => 1111 1111
        return process2(limit, 0, 0, 0);
    }

    /**
     * process2 位运算 eg：8 queens 1表示此列不能放，0表示可以；所有限制求OR
     *
     * @param limit       000...000 11111111 表示后八位可以尝试
     * @param colLim      0000 1000
     * @param leftDiaLim  0001 0000
     * @param rightDiaLim 0000 0100
     * @return 解法个数
     */
    private int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) { //base case所有都填完了
            return 1;
        }
        //所有可以放的位置 colLim = 0...0 0001 000, leftDiaLim = 0...0 0010 0000, rightDiaLim = 0...0 0000 1000
        //colLim | leftDiaLim | rightDiaLim = 0...0 0011 1000
        //~(colLim | leftDiaLim | rightDiaLim) = 1...1 1100 0111
        //pos = 0...0 1100 0111
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim)); //用limit限制位数
        int mostRightOne = 0; //最右侧的1
        int result = 0;
        while (pos != 0) {
            //pos           = 0...0 1100 0111
            //~pos          = 1...1 0011 1000
            //~pos - 1      = 1...1 0011 0111
            //mostRightOne  = 0...0 0000 1000
            mostRightOne = pos & (~pos - 1); //提取最右侧的1，本次尝试的位置
            pos = pos - mostRightOne; //更新pos
            //colLim | mostRightOne 新的列限制
            //(leftDiaLim | mostRightOne) << 1 新的左斜线
            //(rightDiaLim | mostRightOne) >>> 1 新的右斜线
            result += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return result;
    }

    /**
     * process1递归
     * 时间复杂度pow（n，n）
     *
     * @param i      目前来到了第i行
     * @param record [0~i-1] 已经摆好的queen
     * @param n      一共有n行
     * @return 解法个数
     */
    private int process1(int i, int[] record, int n) {
        if (i == n) { //record[0~n-1]存着解法，i==n说明算法终止，有解
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) { //在第i行，0~j-1列遍历尝试，检查是否不共行、列、斜线
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, j); //对j的每一种解法分别做深度优先并累加
            }
        }
        return res;
    }

    /**
     * record[0~i-1]
     * 必定不共行，只需检查是否共列or共斜线（45° or 135°）
     *
     * @param record [0~i-1] 已经摆好的queen
     * @param i      row i
     * @param j      column j
     * @return ture or false
     */
    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { //遍历record[0~i-1]
            if (j == record[k] || Math.abs(i - k) == Math.abs(j - record[k])) { //(i,j) and (k, record[k])
                return false;
            }
        }
        return true;
    }
}
