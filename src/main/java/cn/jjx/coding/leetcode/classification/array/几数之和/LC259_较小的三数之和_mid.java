package cn.jjx.coding.leetcode.classification.array.几数之和;

import java.util.Arrays;

public class LC259_较小的三数之和_mid {

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    //计算两数之和小于目标的
    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                //这块可以看成左指针不动，又指针向左移。
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

}
