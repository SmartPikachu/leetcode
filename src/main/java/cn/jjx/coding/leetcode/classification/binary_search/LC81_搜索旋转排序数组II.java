package cn.jjx.coding.leetcode.classification.binary_search;

public class LC81_搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return false;
        }
        if(nums.length==1) return nums[0]==target;
        return binarySearch(nums,target);
    }

    public boolean binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[left]==nums[mid]&&nums[right]==nums[mid]){
                left++;
                right--;
            }else if(nums[left]<=nums[mid]){
                if(target<nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }

}
