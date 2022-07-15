package cn.jjx.coding.leetcode.classification.array;

import java.util.Arrays;

public class OF_45_把数组排成最小的数_mid {

    //注意排序的规则，x+y与y+x比较
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
