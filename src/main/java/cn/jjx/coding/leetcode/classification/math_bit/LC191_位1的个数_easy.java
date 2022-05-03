package cn.jjx.coding.leetcode.classification.math_bit;

public class LC191_位1的个数_easy {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
