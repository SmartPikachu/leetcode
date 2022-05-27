package cn.jjx.coding.leetcode.classification.dynamic_programming;

import java.util.Arrays;

public class LC698_划分为k个相等的子集_mid {

    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) {
                return true;
            }

            int len = nums.length;
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            if (nums[len - 1] > target) {
                return false;
            }

            int size = 1 << len;
            boolean[] dp = new boolean[size];
            dp[0] = true;
            int[] currentSum = new int[size];
            for (int i = 0; i < size; i++) {
                // 总是基于 dp[i] = true 的前提下进行状态转移
                if (!dp[i]) {
                    continue;
                }

                // 基于当前状态，添加一个数以后
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) != 0) {
                        continue;
                    }
                    int next = i | (1 << j);
                    if (dp[next]) {
                        continue;
                    }
                    if ((currentSum[i] % target) + nums[j] <= target) {
                        currentSum[next] = currentSum[i] + nums[j];
                        dp[next] = true;
                    } else {
// 由于数组已经排好序，如果 (currentSum[i] % target) + nums[j] > target，剩下的数就没有必要枚举
                        break;
                    }
                }
            }
            return dp[size - 1];
        }
    }

}
