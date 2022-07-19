package cn.jjx.coding.leetcode.classification.binary_search.旋转数组;

public class LC81_搜索旋转排序数组II_mid {

    //官方题解
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


    //李为为方法一
    public class Solution {

        // 中间的数与左边界比较
        public boolean search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return false;
            }

            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[left]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        // 落在前有序数组里
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < nums[left]) {
                    // 让分支和上面分支一样
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } else {
                    // 要排除掉左边界之前，先看一看左边界可以不可以排除
                    if (nums[left] == target) {
                        return true;
                    } else {
                        left = left + 1;
                    }
                }

            }
            // 后处理，夹逼以后，还要判断一下，是不是 target
            return nums[left] == target;
        }
    }


    //李为为方法二
    public class Solution1 {

        // 中间的数与右边界比较
        public boolean search(int[] nums, int target) {
            int len = nums.length;

            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] < nums[right]) {
                    // 具体例子：[10, 11, 4, 5, 6, 7, 8, 9]，mid 右边的一定是顺序数组，包括 nums[mid]
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] > nums[right]) {
                    // 具体例子：[4, 5, 9, 2]，mid 左边是一定是顺序数组，包括 nums[mid]
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                } else {
                    if (nums[right] == target) {
                        return true;
                    }
                    right = right - 1;
                }
            }
            return nums[left] == target;
        }
    }

}
