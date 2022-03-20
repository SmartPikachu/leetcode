package cn.jjx.coding.leetcode.labuladong.array;

import java.util.HashMap;
import java.util.Map;

public class LC1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hashtable = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
