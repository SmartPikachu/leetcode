package cn.jjx.coding.leetcode.classification.math_bit;

public class LC231_2的幂_easy {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }

    static final int BIG = 1 << 30;

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && BIG % n == 0;
    }


}
