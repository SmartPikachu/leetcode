package cn.jjx.coding.leetcode.classification.math_bit;

import java.util.Arrays;

public class LC204_计数质数 {
    public int countPrimes(int n) {
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
