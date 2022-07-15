package cn.jjx.coding.leetcode.classification.array.位运算;

public class OF_56_I_数组中数字出现的次数_mid {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;

        //通过这种方法找到第一个不为0的位，这个比x&-x这种方法要好，因为x&-x有溢出的可能。
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
