package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC647_回文子串 {

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }


    public int countSubstrings1(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = s.length();
        for(int i = 0; i<n; i++) dp[i][i] = true;
        for(int i = n-1; i>=0; i--){
            for(int j = i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i == 1){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j]){
                    result++;
                }
            }
        }
        return result;

    }

}
