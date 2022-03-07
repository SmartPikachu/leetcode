package cn.jjx.coding.leetcode.labuladong.binary_search;

public class 二分搜索模板 {

    public int binary_search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    public int left_bound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] == target){
                //别返回，收缩右边界，锁定左边界。
                right=mid -1;
            }
        }

        //最后要检查左边界left越界的情况
        if(left>=nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public int right_bound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid] == target){
                left=mid+1;
            }
        }
        if(right<0 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
