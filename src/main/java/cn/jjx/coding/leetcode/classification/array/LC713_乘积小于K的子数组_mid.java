package cn.jjx.coding.leetcode.classification.array;

import java.util.Arrays;

public class LC713_乘积小于K的子数组_mid {

    /**
     * double 类型只能保证15位有效数字是精确的。为了避免计算带来的误差，
     * 我们将不等式 logPrefix[l]>logPrefix[j+1]−logk 的右边加上 10^{-10}
     * 题目中的double 数值整数部分的数字不超过 5 个），
     * 即logPrefix[l]>logPrefix[j+1]−logk+10^-10
     * 从而防止不等式两边数值相等却被判定为大于的情况。
     */

    //二分法
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int n=nums.length;
        double[] logPrefix=new double[n+1];
        for(int i=0;i<n;i++){
            logPrefix[i+1]=logPrefix[i]+Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int ret=0;
        for(int j=0;j<n;j++){
            int l=0;
            int r=j+1;
            int idx=j+1;
            double val = logPrefix[j+1]-logk+1e-10;
            while(l<=r){
                int mid = (l+r)/2;
                if(logPrefix[mid]>val){
                    idx=mid;
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            ret+=j+1-idx;
        }
        return ret;
    }


    //滑动窗口的方法
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n=nums.length,ret=0;
        int prod = 1,i=0;
        for(int j=0;j<n;j++){
            prod*=nums[j];
            while(i<=j&&prod>=k){
                prod/=nums[i];
                i++;
            }
            ret+=j-i+1;
        }
        return ret;
    }
}
