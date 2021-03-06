package cn.jjx.coding.leetcode.classification.binary_search.旋转数组;

public class LC153_寻找旋转排序数组中的最小值_mid {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

}
