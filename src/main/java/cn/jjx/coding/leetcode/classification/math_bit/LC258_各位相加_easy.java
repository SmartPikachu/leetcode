package cn.jjx.coding.leetcode.classification.math_bit;

public class LC258_各位相加_easy {

    public int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

}
