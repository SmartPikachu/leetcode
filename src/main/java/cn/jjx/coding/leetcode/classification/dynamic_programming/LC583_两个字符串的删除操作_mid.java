package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC583_两个字符串的删除操作_mid {

    /**
     *为了使删除操作的次数最少，剩下的字符应尽可能多。
     * 当剩下的字符为两个字符串的最长公共子序列时，删除操作的次数最少。
     * 因此，可以计算两个字符串的最长公共子序列的长度，
     * 然后分别计算两个字符串的长度和最长公共子序列的长度之差，
     * 即为两个字符串分别需要删除的字符数，
     * 两个字符串各自需要删除的字符数之和即为最少的删除操作的总次数。
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        return m - lcs + n - lcs;
    }


    //或者直接采用动态规划，dp[i][j]表示使word1[0:i]和word2[0:j]相同的最小删除次数。
    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
