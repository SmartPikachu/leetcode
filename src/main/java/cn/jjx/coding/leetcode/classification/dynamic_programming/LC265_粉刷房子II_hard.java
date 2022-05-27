package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC265_粉刷房子II_hard {

    class Solution {
        public int minCostII(int[][] costs) {
            int[][] dp = new int[costs.length][costs[0].length];
            for (int k = 0; k < costs[0].length; k++) {
                dp[0][k] = costs[0][k];
            }
            for (int i = 1; i < costs.length; i++) {
                for (int k = 0; k < costs[0].length; k++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j < costs[0].length; j++) {
                        if (j != k) {
                            min = Math.min(min, dp[i-1][j]);
                        }
                    }
                    dp[i][k] = min + costs[i][k];
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < dp[0].length; i++) {
                result = Math.min(result, dp[dp.length-1][i]);
            }
            return result;
        }
    }

    //这种方法很巧妙，例如第i个楼选择颜色k,则i-1楼不能选择颜色，而此时
    //如果i-1以颜色k时为最小，那么只能求第二小的颜色了。
    class Solution1 {
        public int minCostII(int[][] costs) {
            int[][] dp = new int[costs.length][costs[0].length];
            int fristMinCost = Integer.MAX_VALUE;
            int secondMinCost = Integer.MAX_VALUE;

            int K = costs[0].length;
            for (int k = 0; k < K; k++) {
                dp[0][k] = costs[0][k];
                if (costs[0][k] < fristMinCost) {
                    secondMinCost = fristMinCost;
                    fristMinCost = costs[0][k];
                } else {
                    secondMinCost = Math.min(secondMinCost, costs[0][k]);
                }
            }

            for (int i = 1; i < costs.length; i++) {
                int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE;
                for (int k = 0; k < K; k++) {
                    dp[i][k] = ((dp[i-1][k] == fristMinCost) ?
                            secondMinCost : fristMinCost) + costs[i][k];
                    if (dp[i][k] < t1) {
                        t2 = t1;
                        t1 = dp[i][k];
                    } else {
                        t2 = Math.min(t2, dp[i][k]);
                    }
                }
                fristMinCost = t1;
                secondMinCost = t2;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < K; i++) {
                result = Math.min(result, dp[dp.length-1][i]);
            }
            return result;
        }
    }

}
