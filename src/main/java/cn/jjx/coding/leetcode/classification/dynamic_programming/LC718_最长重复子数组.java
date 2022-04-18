package cn.jjx.coding.leetcode.classification.dynamic_programming;

public class LC718_最长重复子数组 {

    //动态规划的方法，dp[i][j]表示A[i:]和B[j:]的最长公共前缀。
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length,m=nums2.length;
        int[][] dp = new int[n+1][m+1];
        int ans=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                dp[i][j]=nums1[i]==nums2[j]?dp[i+1][j+1]+1:0;
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }


    //下面的方法采用滑动窗口的方法
    public int findLength1(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        int ret=0;
        for(int i=0;i<n;i++){
            int len = Math.min(m,n-i);
            int maxlen = maxLength(nums1,nums2,i,0,len);
            ret=Math.max(ret,maxlen);
        }
        for(int i=0;i<m;i++){
            int len=Math.min(n,m-i);
            int maxlen=maxLength(nums1,nums2,0,i,len);
            ret=Math.max(ret,maxlen);
        }
        return ret;
    }

    public int maxLength(int[] nums1, int[] nums2, int add1, int add2, int len){
        int ret=0,k=0;
        for(int i=0;i<len;i++){
            if(nums1[add1+i]==nums2[add2+i]){
                k++;
            }else{
                k=0;
            }
            ret=Math.max(ret,k);
        }
        return ret;
    }

}
