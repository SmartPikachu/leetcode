package cn.jjx.coding.leetcode.classification.binary_search;

public class LC287_寻找重复数 {
    public int findDuplicate(int[] nums){
        int n = nums.length;
        int left=0,right=n-1,ans=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int cnt=0;
            for(int i=0;i<n;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt<=mid){
                left=mid+1;
            }else{
                right=mid-1;
                ans=mid;
            }
        }
        return ans;
    }

}
