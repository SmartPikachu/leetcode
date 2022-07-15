package cn.jjx.coding.leetcode.classification.array;

import java.util.HashMap;
import java.util.Map;

public class LC525_连续数组_mid {

    /**
     *规定空的前缀的结束下标为 -1，由于空的前缀的元素和为 0，因此在遍历之前，首先在哈希表中存入键值对 (0,-1)
     * 这道题采用的方法是前缀和+哈希表的方法，如果两个前缀和相等，那么他们之差的和就为零。
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

}
