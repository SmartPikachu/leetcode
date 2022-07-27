package cn.jjx.coding.leetcode.classification.dynamic_programming.路径问题;

public class LC64_最小路径和_mid {

    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int n=grid.length, m=grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=1;i<n;i++){
            dp[i][0]+=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<m;j++){
            dp[0][j]+=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],
                        dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
}
