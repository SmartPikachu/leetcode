package cn.jjx.coding.leetcode.classification.dynamic_programming;

import java.util.Arrays;

public class LC698_划分为k个相等的子集_mid {

    //回溯的方法
    class Solution1 {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum=0;
            boolean[] used=new boolean[nums.length];
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++)
            {
                sum+=nums[i];
            }
            if(sum%k!=0)
                return false;
            int target=sum/k;
            if(nums[nums.length-1]>target)
                return false;
            return dfs(nums,nums.length-1,target,0,k,used);
        }

        public boolean dfs(int[] nums,int begin,int target,int curSum,int k,boolean[] used)
        {
            //剪枝1
            if(k==1)
                return true;
            if(curSum==target)
                return dfs(nums,nums.length-1,target,0,k-1,used);//找到了一个组合,还有k-1个.
            //剪枝4
            for(int i=begin;i>=0;i--)
            {
                //使用过的元素就不能再使用了
                if(used[i])
                    continue;
                //剪枝2
                if(curSum+nums[i]>target)
                    continue;
                used[i]=true;//添加元素nums[i]
                if(dfs(nums,i-1,target,curSum+nums[i],k,used))
                    return true;//如果添加这个元素后，完成了题目要求，就return true.
                used[i]=false;//回溯
                while(i>0&&nums[i-1]==nums[i])//剪枝3
                    i--;
            }
            return false;
        }
    }


    //这个是官方题解，状态压缩看懂了，0代表不选，1代表选。
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k == 1) {
                return true;
            }

            int len = nums.length;
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            if (nums[len - 1] > target) {
                return false;
            }

            int size = 1 << len;
            boolean[] dp = new boolean[size];
            dp[0] = true;
            int[] currentSum = new int[size];
            for (int i = 0; i < size; i++) {
                // 总是基于 dp[i] = true 的前提下进行状态转移
                if (!dp[i]) {
                    continue;
                }

                // 基于当前状态，添加一个数以后
                for (int j = 0; j < len; j++) {
                    if ((i & (1 << j)) != 0) {
                        continue;
                    }
                    int next = i | (1 << j);
                    if (dp[next]) {
                        continue;
                    }
                    if ((currentSum[i] % target) + nums[j] <= target) {
                        currentSum[next] = currentSum[i] + nums[j];
                        dp[next] = true;
                    } else {
// 由于数组已经排好序，如果 (currentSum[i] % target) + nums[j] > target，剩下的数就没有必要枚举
                        break;
                    }
                }
            }
            return dp[size - 1];
        }
    }

}
