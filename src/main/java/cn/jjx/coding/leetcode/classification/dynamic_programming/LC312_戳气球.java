package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC312_戳气球 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0]=points[n+1]=1;
        for(int i=1;i<=n;i++){
            points[i]=nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=n-1;i>=0;i--){
            for(int j=i+2;j<=n+1;j++){
                for(int k=i+1;k<j;k++){
                    int sum = points[i]*points[k]*points[j];
                    sum += dp[i][k]+dp[k][j];
                    dp[i][j]=Math.max(dp[i][j],sum);
                }
            }
        }
        return dp[0][n+1];

    }
}
