package cn.jjx.coding.leetcode.classification.array.几数之和;

import java.util.HashMap;
import java.util.Map;

public class LC454_四数相加II_mid {

    //这道题就是hash表的典型应用，先把A+B的和求出，然后用A+B的map去判断C+D的值，方法非常巧妙。
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }

}
