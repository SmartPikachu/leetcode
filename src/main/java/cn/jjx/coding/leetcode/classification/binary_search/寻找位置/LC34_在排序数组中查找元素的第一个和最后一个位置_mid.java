package cn.jjx.coding.leetcode.classification.binary_search.寻找位置;

public class LC34_在排序数组中查找元素的第一个和最后一个位置_mid {

    /**
     *如果lower为true，则查找第一个大于等于target的下标，
     * 否则查找第一个大于target的下标。
     */
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length &&
                nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                //此处寻找如果是lower为true，nums[mid]>=target,则寻找左边界，就是满足条件最小的left
                //如果lower为false,则nums[mid]>target那么寻找的是第一个大于target的右边界
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    //李为为的题解，这块采用开区间的，可以看看。
    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1..right]
                    left = mid + 1;
                } else {
                    // nums[mid] >= target，下一轮搜索区间是 [left..mid]
                    right = mid;
                }
            }

            // 退出循环以后不能确定 nums[left] 是否等于 target，因此需要再判断一次
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // 下一轮搜索区间是 [left..mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间是 [mid..right]
                    left = mid;
                }
            }
            // 主程序先执行 findFirstPosition，能执行到 findLastPosition
            // 说明数组中一定存在等于 target 的元素，因此这里不用判断 nums[left] 是否等于 target
            return left;
        }
    }

}
