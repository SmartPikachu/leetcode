package cn.jjx.coding.leetcode.labuladong.dynamic_programming;

import java.util.Arrays;

public class LC300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2) return len;
        int[] dp = new int[len];
        int res = 1;
        Arrays.fill(dp,1);
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
