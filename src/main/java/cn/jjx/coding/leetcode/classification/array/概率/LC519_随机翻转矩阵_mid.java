package cn.jjx.coding.leetcode.classification.array.概率;

import java.util.*;

public class LC519_随机翻转矩阵_mid {

    //参考官方题解吧，方法一，每次翻转都把total减一，然后就翻转的x映射到total末尾。
    Map<Integer, Integer> map = new HashMap<>();
    int m, n, total;
    Random rand = new Random();

    public LC519_随机翻转矩阵_mid(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int x = rand.nextInt(total);
        total--;
        // 查找位置 x 对应的映射
        int idx = map.getOrDefault(x, x);
        // 将位置 x 对应的映射设置为位置 total 对应的映射
        map.put(x, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }


}
