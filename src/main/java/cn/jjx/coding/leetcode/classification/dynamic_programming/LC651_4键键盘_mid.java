package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC651_4键键盘_mid {
    public int maxA(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+1;
            for(int j=2;j<i;j++){
                dp[i]=Math.max(dp[i],dp[j-2]*(i-j+1));
            }
        }
        return dp[n];
    }
}
