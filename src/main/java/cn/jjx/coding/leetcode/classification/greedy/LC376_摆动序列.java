package cn.jjx.coding.leetcode.classification.greedy;

public class LC376_摆动序列 {

    //采用贪心算法，最佳。
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }


    //采用动态规划
    public int wiggleMaxLength1(int[] nums){
        int n = nums.length;
        if(n<2) return n;
        int[] up = new int[n];
        int[] down = new int[n];
        up[0]=down[0]=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up[i]=Math.max(up[i-1],down[i-1]+1);
                down[i]=down[i-1];
            }else if(nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=Math.max(up[i-1]+1,down[i-1]);
            }else {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }

}
