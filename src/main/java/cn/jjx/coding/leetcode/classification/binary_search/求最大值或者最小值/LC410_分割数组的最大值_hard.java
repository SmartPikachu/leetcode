package cn.jjx.coding.leetcode.classification.binary_search.求最大值或者最小值;

import java.util.Arrays;

public class LC410_分割数组的最大值_hard {

    /**
     *贪心地模拟分割的过程，从前到后遍历数组，用sum 表示当前分割子数组的和，
     * cnt 表示已经分割出的子数组的数量（包括当前子数组），
     * 那么每当 sum 加上当前值超过了x，我们就把当前取的值作为新的一段分割子数组的开头，
     * 并将 cnt 加 1。遍历结束后验证是否 cnt不超过m。
     * 这样我们可以用二分查找来解决。二分的上界为数组nums中所有元素的和，
     * 下界为数组nums 中所有元素的最大值。通过二分查找，
     * 我们可以得到最小的最大分割子数组和，这样就可以得到最终的答案了。
     *
     */
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }



    //或者采用动态规划
    public int splitArray1(int[] nums,int m){
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int[] sub = new int[n+1];
        for(int i=0;i<n;i++){
            sub[i+1]=sub[i]+nums[i];
        }
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(i,m);j++){
                for(int k=0;k<i;k++){
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[k][j-1],sub[i]-sub[k]));
                }
            }
        }
        return dp[n][m];
    }

}
