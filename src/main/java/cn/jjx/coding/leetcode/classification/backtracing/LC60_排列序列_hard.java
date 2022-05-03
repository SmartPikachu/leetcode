package cn.jjx.coding.leetcode.classification.backtracing;

import java.util.Arrays;

public class LC60_排列序列_hard {

    //方法一李为为
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;

    public String getPermutation(int n,int k){
        this.n=n;
        this.k=k;
        calculateFactorial(n);
        used=new boolean[n+1];
        StringBuilder path = new StringBuilder();
        dfs(0,path);
        return path.toString();
    }

    private void dfs(int index,StringBuilder path){
        if(index==n){
            return;
        }
        int cnt = factorial[n-1-index];
        for(int i=1;i<=n;i++){
            if(used[i]){
                continue;
            }
            if(cnt<k){
                k-=cnt;continue;
            }
            path.append(i);
            used[i]=true;
            dfs(index+1,path);
            return;
        }
    }

    private void calculateFactorial(int n){
        factorial=new int[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++){
            factorial[i]=factorial[i-1]*i;
        }
    }

    //非递归的方法
    public String getPermutation1(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }

}
