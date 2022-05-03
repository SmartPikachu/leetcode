package cn.jjx.coding.leetcode.classification.games;

public class LC486_预测赢家_mid {
    public boolean PredictTheWinner(int[] nums) {
        /**
         * dp[i][j]表示当数组剩下的部分为下标i到下标j时，即[i,j]中，
         * 当前玩家与另外一个玩家分数之差的最大值，注意当前玩家不一定
         * 是先手。
         */
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                //这块要注意方向，因为是从后向前，
                // 所有dp[i+1][j]和dp[i][j-1]是在dp[i][j]前面的。
                //其实是有dp[i+1][j]和dp[i][j-1]推到dp[i][j]
                //因为前面两个也比[i,j]短
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j],
                        nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
