package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC276_栅栏涂色_mid {

    public int numWays(int n, int k) {
        int[] f = new int[n+1];   // 方案数表，f[3] 表示给 3 个栅栏上色的方案数
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                f[i] = k;
            } else if (i == 2) {
                f[i] = k * k;
            } else {
                // 第 n 个栅栏如果和上一个不同颜色，则有 f[i-1] * (k-1) 个方案数
                // 第 n 个栅栏如果和上一个同颜色，那么上一个和前一个就不能同颜色，则有 f[i-2] * (k-1)
                // 第 n 个栅栏上色方案数合计：f[i-1] * (k-1) + f[i-2] * (k-1)
                f[i] = f[i - 1] * (k - 1) + f[i - 2] * (k - 1);
            }
        }
        return f[n];
    }

}
