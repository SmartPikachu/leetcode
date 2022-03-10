package cn.jjx.coding.leetcode.labuladong.dynamic_programming;

public class LC1312_让字符串成为回文串的最少插入次数 {

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=n-2;i>=0;i--){
            char c1 = s.charAt(i);
            for(int j=i+1;j<n;j++){
                char c2 = s.charAt(j);
                if(c1==c2){
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][n-1];
    }
}
