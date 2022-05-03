package cn.jjx.coding.leetcode.classification.math_bit;

public class LC136_只出现一次的数字_easy {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
