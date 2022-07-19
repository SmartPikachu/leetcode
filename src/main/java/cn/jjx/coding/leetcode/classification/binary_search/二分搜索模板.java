package cn.jjx.coding.leetcode.classification.binary_search;

public class 二分搜索模板 {

    /**
     *二分法其实不用考虑什么模板都没用，需要根据实际情况选择是<还是<=
     *主要还是看搜索区间，根据搜索区间来判断最终left和right所在的位置。
     * 比如如果是闭区间left<=right,那么搜索到最后跳出的条件是left>right
     * 如果是开区间left<right,那么最后的跳出条件是left==right
     * 所以根本不需要什么模板，主要看需求，以及left,right的位置。
     */

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

    //TODO 后面补充一下开区间的解法。

}
