package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC926_将字符串翻转到单调递增_mid {

    //前缀和
    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N-j-(P[N]-P[j]));
        }

        return ans;
    }


    //dp[i][0]表示前i个元素，最后一个元素为0的最小翻转次数；
    //dp[i][1]表示前i个元素，最后一个元素为1的最小翻转次数
    public int minFlipsMonoIncr1(String s) {
        int dp[][]=new int[s.length()][2];
        //初始化
        dp[0][0]=s.charAt(0)=='0'?0:1;
        dp[0][1]=s.charAt(0)=='1'?0:1;
        //状态转移
        for (int i = 1; i <s.length() ; i++) {
            dp[i][0]=dp[i-1][0]+(s.charAt(i)=='0'?0:1);
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+
                    (s.charAt(i)=='1'?0:1);
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }

}
