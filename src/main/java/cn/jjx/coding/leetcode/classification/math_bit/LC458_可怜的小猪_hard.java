package cn.jjx.coding.leetcode.classification.math_bit;

public class LC458_可怜的小猪_hard {

    //动态规划的方法，用 f(i,j)表示i只小猪测试j轮
    //最多可以在多少桶液体中确定有毒的是哪一桶
    //在确定最大测试轮数为iterations的情况下，
    //需要计算使得f(i,iterations)≥buckets 成立的最小的i。
    //下面的算法更像用编程去实现一系列的计算公式，本质不难。
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int[][] combinations = new int[buckets + 1][buckets + 1];
        combinations[0][0] = 1;
        int iterations = minutesToTest / minutesToDie;
        int[][] f = new int[buckets][iterations + 1];
        for (int i = 0; i < buckets; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j <= iterations; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < buckets; i++) {
            combinations[i][0] = 1;
            combinations[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];
            }
            for (int j = 1; j <= iterations; j++) {
                for (int k = 0; k <= i; k++) {
                    f[i][j] += f[k][j - 1] * combinations[i][i - k];
                }
            }
            if (f[i][iterations] >= buckets) {
                return i;
            }
        }
        return 0;
    }


    //数学推导的方法
    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }

}
