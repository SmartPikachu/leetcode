package cn.jjx.coding.leetcode.labuladong.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LC887_鸡蛋掉落 {

    //动态规划+二分法，另外这里的n*100+k只是作为一个唯一的key没有什么特殊含义。
    Map<Integer,Integer> memo = new HashMap<>();

    public int superEggDrop(int k, int n) {
        return dp(k,n);
    }
    public int dp(int k,int n){
        if(!memo.containsKey(n*100+k)){
            int ans;
            if(n==0){
                ans=0;
            }else if(k==1){
                ans=n;
            }else{
                int lo=1,hi=n;
                while(lo+1<hi){
                    int mid = (lo+hi)/2;
                    int t1 = dp(k-1,mid-1);
                    int t2 = dp(k,n-mid);
                    if(t1<t2){
                        lo=mid;
                    }else if(t1>t2){
                        hi=mid;
                    }else{
                        lo=hi=mid;
                    }
                }
                ans=1+Math.min(Math.max(dp(k-1,lo-1),dp(k,n-lo))
                ,Math.max(dp(k-1,hi-1),dp(k,n-hi)));
            }
            memo.put(n*100+k,ans);
        }
        return memo.get(n*100+k);
    }
}
