package cn.jjx.coding.leetcode.classification.binary_search;

public class LC540_有序数组中的单一元素_mid {

    //参考官方题解，本题是根据奇偶性来判断。
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //如果是偶数比较nums[mid]和nums[mid+1]
            //如果是奇数比较nums[mid]和nums[mid-1],
            // 如果相等调整左边界，如果不相等调整右边界
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
