package cn.jjx.coding.leetcode.classification.math_bit;

public class LC458_可怜的小猪 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }
}
