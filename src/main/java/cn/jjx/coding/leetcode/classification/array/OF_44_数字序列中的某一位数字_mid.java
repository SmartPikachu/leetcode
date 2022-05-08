package cn.jjx.coding.leetcode.classification.array;

public class OF_44_数字序列中的某一位数字_mid {

    //官方题解，必须要找到规律，列出表达式才能解出来
    //代码是真的简洁优美，思路是真的难想
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}
