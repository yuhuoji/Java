package com.bilibili.chapter09;

/**
 * @date 2022-12-04 14:19
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 * 【举例】
 * arr=[1,2,100,4]。
 * 开始时，玩家A只能拿走1或4。如果开始时玩家A拿走1，则排列变为[2,100,4]，接下来玩家B可以拿走2或4，然后继续轮到玩家A...
 * 如果开始时玩家A拿走4，则排列变为[1,2,100]，接下来玩家B可以拿走1或100，然后继续轮到玩家A...
 * 玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，
 * 玩家B将拿走100。所以玩家A会先拿1，
 * 让排列变为[2,100,4]，接下来玩家B不管怎么选，100都会被玩家A拿走。玩家A会获胜，分数为101。所以返回101。
 * arr=[1,100,2]。
 * 开始时，玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，分数为100。所以返回100。
 */
public class CardsInLine {
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //返回最后获胜者的分数
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    //从i~j位置尝试，先手
    private int first(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + second(arr, i + 1, j), arr[j] + second(arr, i, j - 1)); //自己可以选i和选j，选更大的，自己下次变后手
    }

    //后手
    private int second(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(first(arr, i + 1, j), first(arr, i, j - 1)); //对手可能选i或j，给自己更小的，自己下次变先手
    }
}
