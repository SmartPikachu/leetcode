package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC72_编辑距离_hard {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        if(m*n==0){
            return m+n;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int down = dp[i-1][j]+1;
                int right = dp[i][j-1]+1;
                int down_right = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    down_right+=1;
                }
                dp[i][j] = Math.min(down,Math.min(right,down_right));
            }
        }
        return dp[n][m];
    }

}
