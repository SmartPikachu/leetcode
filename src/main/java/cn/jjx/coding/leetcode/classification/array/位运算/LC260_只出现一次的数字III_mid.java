package cn.jjx.coding.leetcode.classification.array.位运算;

import java.util.HashMap;
import java.util.Map;

public class LC260_只出现一次的数字III_mid {

    //比较笨的办法是哈希表，效率更高的是位运算。
    class Solution {
        public int[] singleNumber(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            int[] ans = new int[2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    ans[index++] = entry.getKey();
                }
            }
            return ans;
        }
    }


    //采用位运算的方法，注意不要溢出。
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出，另外这个lsb只是作为分类的作用，x&-x可以求最低位是1的那个数
        // 因为是异或，所以所求的一个元素是0，一个是1，按照此分类，把所有该位是0的和1的分别异或。
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
