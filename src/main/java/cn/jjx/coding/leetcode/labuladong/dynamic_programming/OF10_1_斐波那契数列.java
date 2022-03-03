package cn.jjx.coding.leetcode.labuladong.dynamic_programming;

/**
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

 F(0) = 0,F(1)= 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

  

 示例 1：

 输入：n = 2
 输出：1
 示例 2：

 输入：n = 5
 输出：5
  

 提示：

 0 <= n <= 100

 */

public class OF10_1_斐波那契数列 {

    public int fib(int n){
        final int Mod = 1000000007;
        int[] dp = new int[n+1];
        if(n<2){
            return n;
        }
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=(dp[i-1]+dp[i-2])%Mod;
        }
        return dp[n];
    }

    public int fib1(int n){
        final int Mod = 1000000007;
        if(n<2){
            return n;
        }
        int sum=0,pre1=1,pre2=0;
        for(int i=2;i<n+1;i++){
            sum=(pre1+pre2)%Mod;
            pre2=pre1;
            pre1=sum;
        }
        return sum;
    }

}
