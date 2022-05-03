package cn.jjx.coding.leetcode.classification.math_bit;

public class LC371_两整数之和_mid {

    //这个可以参考官方题解的视频，就明白了。
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
