package cn.jjx.coding.leetcode.classification.dynamic_programming.字符串匹配;

public class LC10_正则表达式匹配_hard {


    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //匹配字符串这类题最好都是设置n+1,0代表0个字符。
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=0;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(p.charAt(j-1) == '*'){
                    //这块不用考虑太多，考虑不需要j-1，j这种特殊情况。
                    //此处代码写的非常简洁优雅。
                    dp[i][j] = dp[i][j-2];
                    if(matches(s,p,i,j-1)){
                        //这块是考虑如果匹配往前推进一位，dp[i-1][j]
                        dp[i][j]=dp[i-1][j]||dp[i][j];
                    }
                }else{
                    if(matches(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }

    public boolean matches(String s, String p, int i, int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

}
