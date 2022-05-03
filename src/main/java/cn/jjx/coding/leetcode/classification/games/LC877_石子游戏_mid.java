package cn.jjx.coding.leetcode.classification.games;

public class LC877_石子游戏_mid {
    //推理
    public boolean stoneGame(int[] piles) {
        return true;
    }

    //动态规划
    /**
     * dp[i][j]表示当数组剩下的部分为下标i到下标j时，即[i,j]中，
     * 当前玩家与另外一个玩家分数之差的最大值，注意当前玩家不一定
     * 是先手。这道题和486题预测赢家使用的方法几乎一致
     */
    public boolean stoneGame1(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j],
                        piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

}
