package cn.jjx.coding.leetcode.classification.math_bit;

import java.util.Arrays;

public class LC204_计数质数_mid {

    //普通的枚举方法
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    //埃氏筛
    public int countPrimes1(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        int ans=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]==1){
                ans+=1;
                if((long) i*i<n){
                    for(int j=i*i;j<n;j+=i){
                        isPrime[j]=0;
                    }
                }
            }
        }
        return ans;
    }
}
