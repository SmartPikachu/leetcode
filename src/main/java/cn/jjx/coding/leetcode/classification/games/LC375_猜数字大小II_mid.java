package cn.jjx.coding.leetcode.classification.games;

public class LC375_猜数字大小II_mid {
    public int getMoneyAmount(int n) {
        //f[i][j]是确保[i,j]范围内确保胜利的最小金额。
        //f(1,n)=min{x+max(f(1,x-1),f(x+1,n))}
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j],
                            k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
