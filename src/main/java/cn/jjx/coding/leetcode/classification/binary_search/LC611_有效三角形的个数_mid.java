package cn.jjx.coding.leetcode.classification.binary_search;

import java.util.Arrays;

public class LC611_有效三角形的个数_mid {

    //最优解，采用双指针，把i固定，然后调整j和k,代码非常优雅。
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

    //根据二分法，首先给数组排序，然后只要满足nums[i]+nums[j]>nums[k],找出k即可
    public int triangleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    //宫水三叶的开区间二分法。
    class Solution {
        public int triangleNumber(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    int l = 0, r = j - 1;
                    while (l < r) {
                        int mid = l + r >> 1;
                        if (nums[mid] + nums[j] > nums[i]) r = mid;
                        else l = mid + 1;
                    }
                    if (l == r && nums[r] + nums[j] > nums[i]) ans += j - r;
                }
            }
            return ans;
        }
    }

}
