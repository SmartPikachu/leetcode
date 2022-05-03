package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC53_最大子数组和_easy {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

}
