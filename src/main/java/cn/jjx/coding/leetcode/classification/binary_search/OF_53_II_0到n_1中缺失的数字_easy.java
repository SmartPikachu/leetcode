package cn.jjx.coding.leetcode.classification.binary_search;

public class OF_53_II_0到n_1中缺失的数字_easy {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
