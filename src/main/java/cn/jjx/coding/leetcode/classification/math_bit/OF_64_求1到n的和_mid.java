package cn.jjx.coding.leetcode.classification.math_bit;

public class OF_64_求1到n的和_mid {

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
