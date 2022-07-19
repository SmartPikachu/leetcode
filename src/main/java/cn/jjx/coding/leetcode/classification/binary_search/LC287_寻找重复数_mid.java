package cn.jjx.coding.leetcode.classification.binary_search;

public class LC287_寻找重复数_mid {

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


    //李为为开区间的解法。
    class Solution {

        public int findDuplicate(int[] nums) {
            int len = nums.length; // n + 1 = len, n = len - 1

            // 在 [1..n] 查找 nums 中重复的元素
            int left = 1;
            int right = len - 1;
            while (left < right) {
                int mid = (left + right) / 2;

                // nums 中小于等于 mid 的元素的个数
                int count = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        count++;
                    }
                }

                if (count > mid) {
                    // 下一轮搜索的区间 [left..mid]
                    right = mid;
                } else {
                    // 下一轮搜索的区间 [mid + 1..right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }



}
