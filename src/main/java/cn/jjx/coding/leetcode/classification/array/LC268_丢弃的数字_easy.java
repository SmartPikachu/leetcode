package cn.jjx.coding.leetcode.classification.array;

import java.util.HashSet;
import java.util.Set;

public class LC268_丢弃的数字_easy {
    //位运算
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }


    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }
}
