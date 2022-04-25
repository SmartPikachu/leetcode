package cn.jjx.coding.leetcode.classification.hashtable;

import java.util.*;

public class LC398_随机数索引 {

    class Solution {
        int[] nums;
        Random random;
        public Solution(int[] nums) {
            this.nums=nums;
            random=new Random();

        }

        public int pick(int target) {
            int ans=0;
            for(int i=0,cnt=0;i<nums.length;i++){
                if(nums[i]==target){
                    cnt++;
                    if(random.nextInt(cnt)==0){
                        ans=i;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        Map<Integer, List<Integer>> pos;
        Random random;

        public Solution1(int[] nums) {
            pos = new HashMap<>();
            random=new Random();
            for(int i=0;i<nums.length;i++){
                pos.putIfAbsent(nums[i],new ArrayList<Integer>());
                pos.get(nums[i]).add(i);
            }

        }

        public int pick(int target) {
            List<Integer> indices=pos.get(target);
            return indices.get(random.nextInt(indices.size()));
        }
    }
}
