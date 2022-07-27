package cn.jjx.coding.leetcode.classification.dynamic_programming.路径问题;

public class LC63_不同路径II_mid {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n=obstacleGrid.length, m=obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=obstacleGrid[0][0]==0?1:0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i-1>=0 && obstacleGrid[i-1][j]==0){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j-1>=0 && obstacleGrid[i][j-1]==0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }

}
